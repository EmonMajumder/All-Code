#include <iostream>
#include <chrono>
#include <ctime>
#include <fstream>
#include "HashTable.h"

using namespace std;


//Hash function
unsigned long hash_function(string str) {
    unsigned long i = 0;
    for (int j=0; j<str.length(); j++)
        i += str[j];
    return i % CAPACITY;
}

static LinkedList* linkedlist_insert(LinkedList* list, Ht_item* item) {
    // Inserts the item onto the Linked List
    if (!list) {
        LinkedList* head = new LinkedList();
        head->item = item;
        head->next = NULL;
        list = head;
        return list;
    }
    else if (list->next == NULL) {
        LinkedList* node = new LinkedList();
        node->item = item;
        node->next = NULL;
        list->next = node;
        return list;
    }
    else{
        LinkedList* temp = list;
        while (temp->next) {
            temp = temp->next;
        }

        LinkedList* node = new LinkedList();
        node->item = item;
        node->next = NULL;
        temp->next = node;

        return list;
    }
}

static void free_linkedlist(LinkedList* list) {
    LinkedList* temp = list;
    while (list) {
        temp = list;
        list = list->next;
        free(temp->item);
        free(temp);
    }
}

static LinkedList** create_overflow_buckets(HashTable* table) {
    // Create the overflow buckets; an array of linkedlists
    LinkedList** buckets = new LinkedList*[table->size];
    for (int i=0; i<table->size; i++)
        buckets[i] = NULL;
    return buckets;
}

static void free_overflow_buckets(HashTable* table) {
    // Free all the overflow bucket lists
    LinkedList** buckets = table->overflow_buckets;
    for (int i=0; i<table->size; i++)
        free_linkedlist(buckets[i]);
    free(buckets);
}


Ht_item* create_item(string key, string value) {
    // Creates a pointer to a new hash table item
    Ht_item* item = new Ht_item();
    item->key = key;
    item->value = value;

    return item;
}

HashTable* create_table(int size) {
    // Creates a new HashTable
    HashTable* table = (HashTable*) malloc (sizeof(HashTable));
    table->size = size;
    table->count = 0;
    table->items = (Ht_item**) calloc (table->size, sizeof(Ht_item*));
    for (int i=0; i<table->size; i++)
        table->items[i] = NULL;
    table->overflow_buckets = create_overflow_buckets(table);

    return table;
}

void free_item(Ht_item* item) {
    // Frees an item
    free(item);
}

void free_table(HashTable* table) {
    // Frees the table
    for (int i=0; i<table->size; i++) {
        Ht_item* item = table->items[i];
        if (item != NULL)
            free_item(item);
    }

    free_overflow_buckets(table);
    free(table->items);
    free(table);
}

void handle_collision(HashTable* table, unsigned long index, Ht_item* item) {
    LinkedList* head = table->overflow_buckets[index];

    if (head == NULL) {
        // We need to create the list
        head = new LinkedList();
        head->item = item;
        table->overflow_buckets[index] = head;
        return;
    }
    else {
        // Insert to the list
        table->overflow_buckets[index] = linkedlist_insert(head, item);
        return;
    }
}

void ht_insert(HashTable* table, string key, string value) {
    // Create the item
    Ht_item* item = create_item(key, value);

    // Compute the index
    unsigned long index = hash_function(key);

    Ht_item* current_item = table->items[index];

    if (current_item == NULL) {
        // Key does not exist.
        if (table->count == table->size) {
            // Hash Table Full
            printf("Insert Error: Hash Table is full\n");
            // Remove the create item
            free_item(item);
            return;
        }

        // Insert directly
        table->items[index] = item;
        table->count++;
    }
    else {
        // Scenario 1: We only need to update value
        if (current_item->key == key) {
            table->items[index]->value = value;
            return;
        }
        else {
            // Scenario 2: Collision
            handle_collision(table, index, item);
            return;
        }
    }
}

string ht_search(HashTable* table, string key) {
    // Searches the key in the hashtable
    // and returns NULL if it doesn't exist
    int index = hash_function(key);
    Ht_item* item = table->items[index];
    LinkedList* head = table->overflow_buckets[index];

    // Ensure that we move to items which are not NULL
    while (item != NULL) {
        if (item->key == key)
            return item->value;
        if (head == NULL)
            return {};
        item = head->item;
        head = head->next;
    }
    return {};
}

void ht_delete(HashTable* table, string key) {
    // Deletes an item from the table
    int index = hash_function(key);
    Ht_item* item = table->items[index];
    LinkedList* head = table->overflow_buckets[index];

    if (item == NULL) {
        // Does not exist. Return
        return;
    }
    else {
        if (head == NULL && item->key == key) {
            // No collision chain. Remove the item
            // and set table index to NULL
            table->items[index] = NULL;
            free_item(item);
            table->count--;
            return;
        }
        else if (head != NULL) {
            // Collision Chain exists
            if (item->key == key) {
                // Remove this item and set the head of the list as the new item

                free_item(item);
                LinkedList* node = head;
                head = head->next;
                node->next = NULL;
                table->items[index] = create_item(node->item->key, node->item->value);
                free_linkedlist(node);
                table->overflow_buckets[index] = head;
                return;
            }
            else{
                LinkedList* curr = head;
                LinkedList* prev = NULL;

                while (curr) {
                    if (curr->item->key == key) {
                        if (prev == NULL) {
                            // First element of the chain. Remove the chain
                            if(curr->next == NULL){
                                free_linkedlist(head);
                                table->overflow_buckets[index] = NULL;
                                return;
                            }
                            else{
                                table->overflow_buckets[index] = curr->next;
                                return;
                            }
                        }
                        else {
                            // This is somewhere in the chain
                            prev->next = curr->next;
                            curr->next = NULL;
                            free_linkedlist(curr);
                            //table->overflow_buckets[index] = head;
                            return;
                        }
                    }
                    prev = curr;
                    curr = curr->next;
                }
            }
        }
    }
}

void print_search(HashTable* table, string key) {
    string val;
    val = ht_search(table, key);
    if (val.empty()) {
        cout << key << " does not exist" << endl;
        return;
    }
    else {
        cout << "Key: " << key << " Value: " << val << endl;
    }
}

void print_table(HashTable* table) {
    cout << "\n-------------------" << endl;
    for (int i=0; i<table->size; i++) {
        if (table->items[i]) {
            cout << "Index: " << i << " Key: " << table->items[i]->key << " Value: " << table->items[i]->value << endl;
            if (table->overflow_buckets[i]) {
                cout << "Overflow Bucket => ";
                LinkedList* head = table->overflow_buckets[i];
                while (head) {
                    cout << " Key: " << head->item->key << " Value: " << head->item->value << endl;
                    head = head->next;
                }
            }
            printf("\n");
        }
    }

    cout << "\n-------------------" << endl;
}

string converttolowercase(string &s){

    string newstring;
    for(int i=0;i<s.length();i++)
    {
        newstring+=tolower(s[i]);
    }
    return newstring;
}

void readdictionary(HashTable* table, string &filename){

    string word;
    ifstream dictionary(filename);
    if (dictionary.is_open()) {
        while (getline(dictionary, word)) {
            ht_insert(table, word, word);
        }
        dictionary.close();
    } else {
        cout << "Could not open file to read" << endl;
    }
}

string readfiletocheck(string &filename){

    string document;
    string documentsegment;
    ifstream file(filename);
    if (file.is_open()) {
        while (getline(file, documentsegment)) {
            document+=documentsegment;
        }
        file.close();
    } else {
        cout << "Could not open file to read" << endl;
    }
    return document;
}

void checkerror(HashTable* table, string &filename)
{
    string sampletocheck;
    sampletocheck = readfiletocheck(filename);

    string words[1000];
    int j = 0;

    string newword;

    for(int i=0; i<sampletocheck.length(); i++) {
        if (sampletocheck[i] >= 'A' && sampletocheck[i] <= 'Z')
        {
            newword+=sampletocheck[i];
        }
        else if(sampletocheck[i]>= 'a' && sampletocheck[i] <= 'z')
        {
            newword+=sampletocheck[i];
        }
        else if(!newword.empty())
        {
            words[j] = newword;
            newword = "";
            j++;
        }
    }

    int totalerror = 0;
    string errors[j];

    for(int i = 0; i<j; i++)
    {
        string val;
        auto t1 = chrono::high_resolution_clock::now();
        val = ht_search(table,converttolowercase(words[i]));
        auto t2 = chrono::high_resolution_clock::now();

        //Uncomment following line to find the time required to search each word.
        //cout << "Word: " << words[i] << "\nStart time\t: " << t1.time_since_epoch().count() << "\nEnd time\t: " << t2.time_since_epoch().count() <<"\nDuration\t: " << chrono::duration_cast<chrono::microseconds>(t2 - t1).count() << " microseconds." << "\n" <<endl;

        if (val.empty()) {
            errors[totalerror] = words[i];
            totalerror++;
        }
    }

    if(totalerror == 0)
    {
        cout << "No error found." << endl;
    }else{
        cout << "Following errors found in your file: " << endl;
        for(int i = 0; i<totalerror; i++)
        {
            cout << errors[i] << endl;
        }
    }
}


int main() {
    HashTable* ht = create_table(CAPACITY);

    string dictionary = "..\\dictionary.txt";
    readdictionary(ht,dictionary);

    string filename = "..\\mispelled.txt";
    string filename2 = "..\\sample.txt";

    cout << "File: " << filename << endl;
    checkerror(ht,filename);

    cout << endl;

    cout << "File: " << filename << endl;
    checkerror(ht,filename2);

    cout << endl;

    //print_table(ht);

    string nodetodelete;

    while(true)
    {
        cout << "Word to delete: ";
        getline(cin,nodetodelete);
        if(nodetodelete == "quit")
        {
            break;
        }
        else
        {
            if(!ht_search(ht,nodetodelete).empty())
            {
                ht_delete(ht, nodetodelete);
                cout << "Deleted" << "\n" <<endl;
                print_table(ht);
                cout <<"\n";
            }
            else
            {
                cout << "No matching record was found" << endl;
            }
        }
    }

    free_table(ht);
    return 0;
}


//Acknowledgement:
// Some portions of code used in this program has been copied from
//1. https://www.journaldev.com/35238/hash-table-in-c-plus-plus
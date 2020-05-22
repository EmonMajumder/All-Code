//
// Created by emonc on 2020-04-28.
//

#ifndef UNTITLED_HASHTABLE_H
#define UNTITLED_HASHTABLE_H

#define CAPACITY 50000 // Size of the Hash Table

using namespace std;

typedef struct Ht_item Ht_item;

// Define the Hash Table Item here
struct Ht_item {
    string key;
    string value;
    Ht_item(){
        this->key = "A";
        this->value ="A";
    }
};


typedef struct LinkedList LinkedList;

// Define the Linkedlist here
struct LinkedList {
    Ht_item* item;
    LinkedList* next;

    LinkedList(){
        item = nullptr;
        next = nullptr;
    }
};

typedef struct HashTable HashTable;

// Define the Hash Table here
struct HashTable {
    // Contains an array of pointers
    // to items
    Ht_item** items;
    LinkedList** overflow_buckets;
    int size;
    int count;

    HashTable(){
        items = nullptr;
        overflow_buckets = nullptr;
        size = 1;
        count = 0;
    }
};

#endif //UNTITLED_HASHTABLE_H

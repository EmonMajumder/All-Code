#include <iostream>
#include <chrono>
#include <ctime>
#include <fstream>
#include <algorithm>
#include <regex>
#include "BST.h"
#include "BST.cpp"
using namespace std;

string ValidateInputFilename()
{
    string file;
    string filename;
    ifstream inStream;
    regex rextxt(R"(^\S+(\s\S+)*\.txt$)");
    regex rex(R"(^\S+(\s\S+)*$)");

    //While loop for continually asking filename for invalid input
    while (true)
    {
        cout << "Type exit to close program" << endl;
        cout << "File Name: ";
        getline(cin, filename);

        transform(filename.begin(), filename.end(), filename.begin(),[](unsigned char c) { return tolower(c); });

        if (filename == "exit")
        {
            return filename;
        }

        else
        {
            //Regex comparism
            if (regex_match(filename, rex))
            {
                if (!regex_match(filename, rextxt))
                {
                    filename += ".txt";
                }

                file = "..\\" + filename;
                inStream.open(file);

                if (!inStream.fail())
                {
                    inStream.close();
                    break;
                }
                else
                {
                    cout << "File was not found. Please Check file name." << endl;
                    cin.clear();
                }
            }
            else
            {
                //Check if no input given.
                if (file.empty())
                {
                    cout << "Please input a filename." << endl;
                    cin.clear();
                }
                else
                {
                    cout << "Incorrect filename." << endl;
                    cin.clear();
                }
            }
        }
    }
    return file;
}

void readdictionary(BST &bst, string &filename){

    string word;
    ifstream dictionary(filename);
    if (dictionary.is_open()) {
        while (getline(dictionary, word)) {
            bst.insertnode(word);
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

void checkerror(BST &bst, string &filename)
{
    string sampletocheck;
    sampletocheck = readfiletocheck(filename);

    string words[1000];
    int j = 0;

    string newword = "";

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
    for(int i = 0; i<j; i++)
    {
        if(!bst.searchresult(words[i])){
            if(totalerror == 0)
            {
                cout << "Errors found in your file" << endl;
            }
            cout << words[i] << endl;
            totalerror++;
        }
    }

    if(totalerror == 0)
    {
        cout << "No error found." << endl;
    }
}


int main()
{
    BST bst;
    string dictionary = "..\\dictionary.txt";
    readdictionary(bst,dictionary);

    //cout << bst;

    string filename = "..\\mispelled.txt";
    string filename2 = "..\\sample.txt";

//    string filename;
//    filename = ValidateInputFilename();

    cout << "File: " << filename << endl;
    checkerror(bst,filename);

    cout << endl;

    cout << "File: " << filename << endl;
    checkerror(bst,filename2);

    cout << endl;

//    bst.printvalues();
//    cout <<"\n";
//
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
            if(bst.deleteselectednode(nodetodelete))
            {
                cout << "Deleted" << "\n" <<endl;
                cout << bst;
                cout <<"\n";
            }
            else
            {
                cout << "No matching record was found" << endl;
            }
        }
    }

    return 0;
}



//Acknowledgement:
// Some portions of code used in this program has been copied from two sources
//1. https://gist.github.com/garrettseward/4375442f24f090dcb135c4f23476d6ac
//2. https://www.geeksforgeeks.org/avl-tree-set-1-insertion
//3. https://www.geeksforgeeks.org/avl-tree-set-2-deletion









//
// Created by emonc on 2020-04-22.
//

#ifndef ASSIGNMENT_4_BST_H
#define ASSIGNMENT_4_BST_H
#include "Node.h"


class BST {
private:
    Node *root;
    int max(int a, int b);
    int height(Node *N);
    string getkey(Node *N);
    int getBalance(Node *N);
    Node *rightRotate(Node *y);
    Node *leftRotate(Node *x);
    Node* minValueNode(Node* node);
    Node* insert(Node* node, string key);
    void inOrder(Node *root);
    void printBT(ostream& output, const string& prefix, Node* node, bool isLeft);
    Node* search(Node* root, string key);
    Node* deleteNode(Node* root, string key);
    string converttolowercase(string &s);
    friend bool operator < (string first,string second);
    friend bool operator > (string first,string second);

public:
    BST(): root(nullptr){};
    void printvalues();
    friend ostream& operator<<( ostream &output, BST &bst );
    void insertnode(string &key);
    bool deleteselectednode(string &key);
    bool searchresult(string &key);
};


#endif //ASSIGNMENT_4_BST_H

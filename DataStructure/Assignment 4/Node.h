//
// Created by emonc on 2020-04-20.
//

#ifndef ASSIGNMENT_4_NODE_H
#define ASSIGNMENT_4_NODE_H

using namespace std;

class Node
{
public:
    string key;
    Node *left;
    Node *right;
    int height;

    Node() : key("0"), left(NULL), right(NULL), height(1){};
};


#endif //ASSIGNMENT_4_NODE_H

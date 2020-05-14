//
// Created by emonc on 2020-04-22.
//

#include "BST.h"
#include "Node.h"
using namespace std;

//Function to find greater number.
int BST::max(int a, int b){
    return (a > b)? a : b;
}

//function to find height of branch.
int BST::height(Node *N)
{
    if (N == NULL)
        return 0;
    return N->height;
}

//Function for getting key value.
string BST::getkey(Node *N)
{
    if (N == NULL)
        return 0;
    return N->key;
}

//Function to check if tree is balanced.
int BST::getBalance(Node *N)
{
    if (N == NULL)
        return 0;
    return height(N->left) - height(N->right);
}

//Function to find minimum value in the tree.
Node* BST::minValueNode(Node* node)
{
    Node* current = node;

    /* loop down to find the leftmost leaf */
    while (current->left != NULL)
        current = current->left;

    return current;
}

//Function to convert Uppercase letter to lowercase.
string BST::converttolowercase(string &s){

    string newstring;
    for(int i=0;i<s.length();i++)
    {
        newstring+=tolower(s[i]);
    }
    return newstring;
}

//Function to right rotate the imbalanced tree
Node* BST::rightRotate(Node *y)
{
    Node *x = y->left;
    Node *T2 = x->right;

    // Perform rotation
    x->right = y;
    y->left = T2;

    // Update heights
    y->height = max(height(y->left),
                    height(y->right)) + 1;
    x->height = max(height(x->left),
                    height(x->right)) + 1;

    // Return new root
    return x;
}

//Function to left rotate the imbalanced tree
Node* BST::leftRotate(Node *x)
{
    Node *y = x->right;
    Node *T2 = y->left;

    // Perform rotation
    y->left = x;
    x->right = T2;

    // Update heights
    x->height = max(height(x->left),
                    height(x->right)) + 1;
    y->height = max(height(y->left),
                    height(y->right)) + 1;

    // Return new root
    return y;
}

//Operator to do sequential comparison of letters.
bool operator < (string first,string second)
{
    int i = 0;
    int n = first.length()<second.length()? first.length():second.length();

    while(i<n)
    {
        if(tolower(first[i]) != tolower(second[i]))
        {
            return tolower(first[i]) < tolower(second[i]);
        }
        i++;
    }

    return first.length()<second.length();
}

//Operator to do sequential comparison of letters.
bool operator > (string first,string second)
{
    int i = 0;
    int n = first.length()<second.length()? first.length():second.length();

    while(i<n)
    {
        if(tolower(first[i]) != tolower(second[i]))
        {
            return tolower(first[i]) > tolower(second[i]);
        }
        i++;
    }

    return first.length()>second.length();
}


// Function to call the recursive function to insert a key in the tree rooted with given node
void BST::insertnode(string &key){
    root = insert(root,key);
}

//Recursive function to insert a key in the tree rooted with node and
//returns the new root of the subtree.
Node* BST::insert(Node* node, string key)
{
    /* 1. Perform the normal insertion */
    if (node == NULL)
    {
        Node *newnode = new Node();
        newnode->key = key;
        return newnode;
    }

    if (key < getkey(node))
        node->left = insert(node->left, key);
    else if (key > getkey(node))
        node->right = insert(node->right, key);
    else                                                   // Equal keys are not allowed in BST
        return node;

    /* 2. Update height of this ancestor node */
    node->height = 1 + max(height(node->left),height(node->right));

    /* 3. Get the balance factor of this ancestor
        node to check whether this node became
        unbalanced */
    int balance = getBalance(node);

    // If this node becomes unbalanced, then there are 4 cases

    // Left Left Case
    if (balance > 1 && key < getkey(node->left))
        return rightRotate(node);

    // Right Right Case
    if (balance < -1 && key > getkey(node->right))
        return leftRotate(node);

    // Left Right Case
    if (balance > 1 && key > getkey(node->left))
    {
        node->left = leftRotate(node->left);
        return rightRotate(node);
    }

    // Right Left Case
    if (balance < -1 && key < getkey(node->right))
    {
        node->right = rightRotate(node->right);
        return leftRotate(node);
    }

    /* return the (unchanged) node pointer */
    return node;
}

//Function to delete a node from the tree.
bool BST::deleteselectednode(string &key){
    if(height(root) == 1)
    {
        Node *n = deleteNode(root,key);
        if(n == NULL)
        {
            return true;
        }
    }
    else if(height(root) >1)
    {
        return deleteNode(root,key) != NULL;
    }
    else
    {
        return false;
    }
}

//Recursive function to delete a node from the tree and then autobalance the tree.
Node* BST::deleteNode(Node* root, string key)
{
    // STEP 1: PERFORM STANDARD BST DELETE
    if (root == NULL)
        return root;

    // If the key to be deleted is smaller
    // than the root's key, then it lies
    // in left subtree
    if ( key < root->key )
        root->left = deleteNode(root->left, key);

        // If the key to be deleted is greater
        // than the root's key, then it lies
        // in right subtree
    else if( key > root->key )
        root->right = deleteNode(root->right, key);

        // if key is same as root's key, then
        // This is the node to be deleted
    else
    {
        // node with only one child or no child
        if( (root->left == NULL) ||
            (root->right == NULL) )
        {
            Node *temp = root->left ?
                         root->left :
                         root->right;

            // No child case
            if (temp == NULL)
            {
                temp = root;
                root = NULL;
            }
            else // One child case
                *root = *temp; // Copy the contents of the non-empty child
            free(temp);
        }
        else
        {
            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            Node* temp = minValueNode(root->right);

            // Copy the inorder successor's
            // data to this node
            root->key = getkey(temp);

            // Delete the inorder successor
            root->right = deleteNode(root->right,temp->key);
        }
    }

    // If the tree had only one node
    // then return
    if (root == NULL)
        return root;

    // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
    root->height = 1 + max(height(root->left),height(root->right));

    // STEP 3: GET THE BALANCE FACTOR OF
    // THIS NODE (to check whether this
    // node became unbalanced)
    int balance = getBalance(root);

    // If this node becomes unbalanced,
    // then there are 4 cases

    // Left Left Case
    if (balance > 1 &&
        getBalance(root->left) >= 0)
        return rightRotate(root);

    // Left Right Case
    if (balance > 1 &&
        getBalance(root->left) < 0)
    {
        root->left = leftRotate(root->left);
        return rightRotate(root);
    }

    // Right Right Case
    if (balance < -1 &&
        getBalance(root->right) <= 0)
        return leftRotate(root);

    // Right Left Case
    if (balance < -1 &&
        getBalance(root->right) > 0)
    {
        root->right = rightRotate(root->right);
        return leftRotate(root);
    }

    return root;
}

//Function to search a key from the tree.
bool BST::searchresult(string &key){
    return search(root, converttolowercase(key)) != NULL;
}

//Recursive function to search a key from the tree.
Node* BST::search(Node* root, string key)
{
    // Base Cases: root is null or key is present at root
    if (root == NULL || root->key == key)
        return root;

    // Key is greater than root's key
    if (root->key < key)
        return search(root->right, key);

    // Key is smaller than root's key
    return search(root->left, key);
}

//Function to call recursive function inOrder to print values in minimum to maximum order.
void BST::printvalues(){
    inOrder(root);
}


//Recursive function to print values from minimum to maximum order
void BST::inOrder(Node *root)
{
    if(root != NULL)
    {
        inOrder(root->left);
        cout << root->key <<" ";
        if(height(root->left)-height(root->right) > 1 || height(root->left)-height(root->right) < -1)
        {
            cout <<"\n"<<"------------BST Not Balanced--------------"<< endl;
        }
        inOrder(root->right);
    }
}

//Function to print the tree showing balancing of brach.
void BST::printBT(ostream& output, const string& prefix, Node* node, bool isLeft) {
    if(node != nullptr) {
        output << prefix;

        output << (isLeft ? "├──" : "└──" );

        output << node->key << endl;

        printBT(output,prefix + (isLeft ? "│   " : "    "), node->left, true);
        printBT(output,prefix + (isLeft ? "│   " : "    "), node->right, false);
    }
}


//Operator to print Binary search tree.
ostream& operator << ( ostream &output, BST &bst )
{
    bst.printBT( output,"", bst.root, false);
    return output;
}

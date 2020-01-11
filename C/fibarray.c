/* Sample program to create an array holding the first 15 numbers in the Fibonacci sequence
 * Author: Hal O'Connell
 * January 2018
*/


#include <stdio.h>
#define MAXFIB 25

int main(void) {
    int idx;        /* The index of fibonacci number to be printed next */
    int current;  /* The value of the (i)th fibonacci number */
    int next;     /* The value of the (i+1)th fibonacci number */
    int andnext;  /* The value of the (i+2)th fibonacci number */
    int fibarray[MAXFIB][2];

    printf("\nPrinting Fibonacci numbers - The first %3i of the sequence\n", MAXFIB);
    next = current = 1;
    for (idx=0; idx < MAXFIB; idx++) {
        fibarray[idx][0] = idx+1;
        fibarray[idx][1] = current;
        andnext = current+next;
        current = next;
        next    = andnext;
    }

    printf("\n\nI \t Fibonacci(I) \n=====================\n");

    for (idx=0; idx < MAXFIB; idx++) {
        printf("%2i\t%6i\n", fibarray[idx][0], fibarray[idx][1]);

    }


}
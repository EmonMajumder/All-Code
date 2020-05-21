#include <stdio.h>
#include <stdbool.h>

int main() { /*main function that holds whole program */
    int N = 10; /*Define datatype for variable N and assign 10 as value to N as integer*/
    printf("Here is the table for N X N\n"); /*Publish in the output window*/
    int i=0;
    int j=0;
    for (i = 0; i <= N ; i++){ /*main for loop. Define i as integer and assign value int 10. Loop continue
                                    * until i is less than or equal to N. After completion of each loop
                                    * value of i is increase by 1. i++ equivalent to i=i+1. This defines
                                    * the rows for the output. */

        for (j = 0; j <=N; j++){ /*Nested for loop. This defines column for the output.*/
            if (i==0 & j==0){
                printf("\t   N");
            }
            else if (i==0) {
                printf("\t %3i",j);/*Take 3 character space to put the integer to the output screen*/
            }
            else if (j==0) {
                printf("\t %3i",i);
            }
            else {
                printf("\t %3i", i * j);/*Out put result of i multiplied by j*/
            }
        }
        putchar('\n'); /*Move the cursor to start a new line for publishing output.
                        * Putchar is used for single char and is processed much faster
                        * than Printf function*/
    }

    printf("\nHere is the table for N X N in reverse\n");
    while (i>=1){
        int m=j;/*Assign Value of j to m*/
        while(j>=1) {
            if (i == 11 & j == 11) {
                printf("\t   N");
            }
            else if (i == 11) {
                printf("\t %3i", j);
            }
            else if (j == 11) {
                printf("\t %3i", i);
            }
            else {
                printf("\t %3i", i * j);
            }
            j--;
        }
        j=m;/*Assign value of m to j*/
        i--;
        putchar('\n');
    }
    return 0;
}
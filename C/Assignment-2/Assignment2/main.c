#include <stdio.h>                                           //Standard header file.
#include <stdbool.h>                                         //Header file for handling boolean datatype.
#include <stdlib.h>                                          //Header file for handing "atoi".
#include <string.h>                                          //Header file for handing operations with string.
#include "leapyear.h"                                        //Header file to link function call to actual function file.

int main() {
    int year,i,charValue,checkInt,finalYear=2019;   //Define datatype for variable year,i,charValue,checkInt,finalYear
    char userInput[50];                             //Define a string of char datatype of 50 magnitude.
    bool looped = true;                             //Boolean datatype looped and assigned value 'true'

    while(looped == true) {                         //While loop for repeating user operation. Loop continue for 'true'
                                                    //value of looped.
        checkInt = 0;
        printf("\nPlease Enter Year to Check [Enter 'N' to quit]: ");  //Print on screen asking user input
        scanf("%s", userInput);                                        //Store user input in string userInput
        if(userInput[0]=='N' && strlen(userInput)==1){                 //Logic check if user input is 'N'
                looped=false;                                          //Change value of looped which terminate while loop.
        }
        else {
            for (i = 0; i < strlen(userInput); i++) {                  //Check each user input char if it was a number
                                                                       //by looking to the ascii value of the char.
                charValue = (int) userInput[i];                        //Get the ascii value of char and assign to charvalue.
                if (charValue < 48 || charValue > 57) {                //Check if the ascii value is within range of
                                                                       // ascii value 0 to 9.
                    checkInt++;                                        //checkInt+1
                }
            }
            if (checkInt == 0) {
                year = atoi(userInput);                                //Built in function to convert string to integer.
                if (year == 0) {
                    printf("Invalid User input\n");
                }
                else if (leapyear(year) == true)                       //Call function leapyear and pass value 'year'.
                    printf("%d is a Leap Year\n", year);
                else
                    printf("%d is not a Leap Year\n", year);
            }
            else {
                printf("Invalid User input\n");
            }
        }
    }

    printf("\nPresenting Leap Years from year 1 to 2019\n");
    for (i=1;i<=2019;i++){                                              //Print at Leap Years on the output screen.
        if (leapyear(i) == true)
            printf("%4i\t",i);
        if (i%100==0)
            printf("\n");
    }
}
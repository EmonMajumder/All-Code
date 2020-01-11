#include <stdio.h>

int main() {
    int year, rem_4, rem_100, rem_400;
    printf("Please enter a year to test: ");
    scanf("%i", &year);

    rem_4 =year % 4;
    rem_100 = year % 100;
    rem_400 = year % 400;

    if ((rem_4 == 0 && rem_100 != 0) || rem_400 == 0) {
        printf("A leap year!\n");
    }
    else {
        printf("Not a leap year\n");
    }
    return 0;
}
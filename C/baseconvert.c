#include <stdio.h>

int main() {
    const char baseDigits[16] = {
            '0','1','2','3','4','5','6',
            '7','8','9','A','B','C','D','E','F'
    };
    int convertedNumber[64];
    long int numberToConvert;
    int nextDigit, base, index = 0;

    // get the number and the base

    printf("Number to convert: ");
    scanf ("%ld", &numberToConvert);
    printf ("Base? ");
    scanf ("%i", &base);

    // convert
    do {
        convertedNumber[index] = numberToConvert % base;
        ++index;
        numberToConvert = numberToConvert / base;

    } while (numberToConvert != 0);

    printf ("Converted number = ");
    for (--index; index >=0; --index){
        nextDigit =convertedNumber[index];
        printf("%c", baseDigits[nextDigit]);
    }
    printf ("\n");
    return 0;
}

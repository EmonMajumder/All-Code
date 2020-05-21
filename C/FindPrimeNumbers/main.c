#include <stdio.h>

int main() {
    int p, d, range;
    _Bool isPrime;

    printf("Range: ");
    scanf("%d",&range);

    for (p =2; p <= range; p++ ){
        isPrime = 1;
        for (d = 2; d < p; d++) {
            if (p % d == 0) isPrime = 0;
        }
        if (isPrime !=0) printf("%i ", p);
    }
    printf ("\n");
    return 0;
}
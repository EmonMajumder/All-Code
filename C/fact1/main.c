#include <stdio.h>
#include "factorial.h"


int main() {
	printf("Factorial World!\n");
	int result, num;
	num = 7;
	result = factorial(num);
	printf("%i\t%i\n", num, result);
	
	return 0;
}
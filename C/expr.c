#include <stdio.h>

int main() {
	int a = 100;
	int b = 2;
	int c = 25;
	int d = 4;
	int f = 1;
	int result;
	char chr = 'A';
	float f1 = 123.725, f2;
	int i1, i2 = -150;

	result = a - b; // subtraction
	printf("a - b = %i\n", result);

	result = b * c; // multiplication
	printf("b * c = %i\n", result);

	result = a / c; // division
	printf("a / c = %i\n", result);

	result = a + b * c; // precedence
	printf("a + b * c = %i\n", result);

	printf("a * b + c * d = %i\n", a * b + c * d);

	result = c / d;
	printf("c / d = %i\n", result);

	result = c % d;
	printf("c %% d = %i\n", result);

	f++;
	printf("f = %i\n", f);

	++f;
	printf("f = %i\n", f);

	result = f++;
	printf("f again is = %i\n", result);

	result = ++f;
	printf("f again is = %i\n", result);

	result = (int)chr;
	printf("result now is = %i\n", result);

	i1 = f1;
	printf("i1 now is = %i\n", i1);

	return 0;
}
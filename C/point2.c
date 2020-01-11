#include <stdio.h>

void test (int *int_pointer){
	printf( "Before, pointer to i = %i\n", *int_pointer);
	*int_pointer = 100;
}

int main() {
	void test(int *int_pointer);
	int i = 50, *p = &i;

	printf( "Before, i = %i\n", i);
	test(p);
	printf( "After, i = %i\n", i);
	printf("The pointer p = %i\n", p);
	printf("The pointer p points to = %i\n", *p);


	return 0;
}
#include <stdio.h>
#include <stdbool.h>

int main() {
	bool loopflag = true;
	printf("Here is a little table!\n");
	for (int idx = 0; idx < 20; idx++){

		for (int jdx = 0; jdx <=21; jdx = jdx + 7){
			printf ("\t %4i", jdx * idx);
		}
		putchar('\n');
	}

	while (loopflag){
		printf("Hello, World! from a while loop!\n");
		loopflag = false;
	}

	do {
		printf("Hello, World! from a do  loop!\n");
	} while (loopflag);

	return 0;
}
#include <stdio.h>
#include <stdbool.h>
#include <time.h>
#include "cointoss.h"

int main() {
	bool ishead;
	time_t t;
	srand((unsigned) time(&t));

	printf("Coin Tosser!\n");

	for (int idx = 0; idx < 10; idx++) {
		ishead = cointoss();
		if (ishead) printf("Heads!\n");
		else printf("Tails!\n");
	}


	return 0;
}
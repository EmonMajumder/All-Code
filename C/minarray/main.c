#include <stdio.h>
#include "minimum.h"

#define MAXARRAY 10

int main() {
	int scores[MAXARRAY], i, minScore;
	printf("Min value in an array!\n");
	printf("Enter %i scores: ", MAXARRAY);

	for (i = 0; i < MAXARRAY; i++){
		scanf("%i", &scores[i]);
	}
	minScore = minimum(scores, MAXARRAY);
	printf("\nMinimum score is: %i\n", minScore);

	return 0;
}
#include <stdio.h>
#include "minimum.h"

//#define MAXARRAY 10
const static int MAXARRAY=10;

int main() {
	int scores[MAXARRAY][MAXARRAY], i, j, minScore;
	printf("Min value in an array!\n");
	printf("\n");

	for (i = 0; i < MAXARRAY; i++){
	    for(j = 0;j < MAXARRAY; j++){
	        scores[i][j] = i+j;
	        printf("%4i\t",scores[i][j]);
	    }
        printf("\n");
	}
	minScore = minimum(MAXARRAY, MAXARRAY, scores);
	printf("\nMinimum score is: %i\n", minScore);

	return 0;
}
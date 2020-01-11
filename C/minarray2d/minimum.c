//
// Created by prog2100 on 01/02/18.
//

#include "minimum.h"

int minimum (int xsize, int ysize, int values[xsize][ysize]){
	int minValue, i, j;
	minValue = values[0][0];
	for (i = 1; i < xsize; i++){
	    for (j=0; j < ysize; j++) {
            if (values[i][j] < minValue) minValue = values[i][j];
        }
	}
	return minValue;
}
//
// Created by prog2100 on 01/02/18.
//

#include "minimum.h"

int minimum (int values[], int size){
	int minValue, i;
	minValue = values[0];
	for (i = 1; i < size; i++){
		if (values[i] < minValue ) minValue = values[i];
	}
	return minValue;
}
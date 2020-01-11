//
// Created by prog2100 on 01/02/18.
//

#include "factorial.h"

int factorial(int num){
	int result = 1;
	for (int idx = num; idx >= 1; idx--){
		result = result * idx;
	}
	return result;
}

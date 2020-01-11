//
// Created by prog2100 on 02/02/18.
//

#include "cointoss.h"

bool cointoss(){
	int toss;

	toss = rand() % 2;
	if (toss == 0) return true;
	else return false;

}


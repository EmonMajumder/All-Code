#pragma once
#include "Organism.h"

class Human : public Organism
{
public:
	Human();
	Human(City *city, int x, int y);

	virtual ~Human();
	void move(City *city);
	void nextmovelocation(bool notneeded);
};



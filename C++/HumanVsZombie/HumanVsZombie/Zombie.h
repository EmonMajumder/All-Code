#pragma once
#include "Organism.h"

class Zombie : public Organism
{
public:
	Zombie();
	Zombie(City *city, int x, int y);

	void nextmovelocation(bool convert);
	virtual ~Zombie();
	void move(City *city);
};
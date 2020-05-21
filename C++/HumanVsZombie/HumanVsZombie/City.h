#pragma once
#include <iostream>
#include <vector>
#include "GameSpecs.h"
#include "Organism.h"

using namespace std;

class Organism;

class City
{

private:
	Organism* grid[GRIDSIZE][GRIDSIZE];

public:
	City();

	//Destructor
	virtual ~City();

	//Getter
	Organism *getOrganism(int x, int y);

	//Setter
	void setOrganism(Organism *organism, int x, int y);

	//Operator overloading.
	friend ostream& operator<<(ostream &output, City &world);
};



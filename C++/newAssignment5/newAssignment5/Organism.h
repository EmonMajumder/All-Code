#pragma once
#include <string>

class City;

using namespace std;

class Organism
{
public:
	int x;
	int y;
	bool moved;
	string symbol;
	City *city;
	int movecount;
	int starvecount;

public:
	Organism();

	//Constructor
	Organism(City *city, int x, int y);

	virtual ~Organism() = 0;
	virtual void move(City *city) = 0;
	virtual void nextmovelocation(bool convert) = 0;
};



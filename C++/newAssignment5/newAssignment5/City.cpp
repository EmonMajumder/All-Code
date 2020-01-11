#include "pch.h"
#include "City.h"
#include "City.h"
#include "GameSpecs.h"
#include <iostream>
#include <vector>
#include "Organism.h"
#include <windows.h>

using namespace std;

//Constructor
City::City()
{
	for (int i = 0;i < GRIDSIZE;i++)
	{
		for (int j = 0; j < GRIDSIZE; j++)
		{
			this->grid[i][j] = nullptr;
		}
	}
}

//Destructor
City::~City()
{
	for (int i = 0;i < GRIDSIZE;i++)
	{
		for (int j = 0;j < GRIDSIZE;j++)
		{
			if (this->grid[i][j] != nullptr)
			{
				delete[] grid[i][j];
			}
		}
	}
}

//Getter
Organism* City::getOrganism(int y, int x)
{
	return grid[y][x];
}

//Setter
void City::setOrganism(Organism *organism, int y, int x)
{
	grid[y][x] = organism;
}


//Function that handles color output to console.
void Color(int c)
{
	HANDLE  hConsole;
	hConsole = GetStdHandle(STD_OUTPUT_HANDLE);
	SetConsoleTextAttribute(hConsole, c);
}

//Operator overloading for console put of city grid
ostream& operator<<(ostream &output, City &world)
{
	int O = 0;
	int Z = 0;

	for (int i = 0;i < GRIDSIZE;i++) {
		for (int j = 0; j < GRIDSIZE; j++)
		{
			//if (j == 0)
			//{
			//	Color(7);
			//	output << "|";
			//}

			if (world.getOrganism(i, j) != nullptr)
			{
				if (world.getOrganism(i, j)->symbol == HUMAN_CH)
				{
					Color(2);
					output << world.getOrganism(i, j)->symbol << " ";

					//output << "|";

					O++;
				}
				else if (world.getOrganism(i, j)->symbol == ZOMBIE_CH)
				{
					Color(4);
					output << world.getOrganism(i, j)->symbol << " ";

					//output << "|";

					Z++;
				}
			}
			else
			{
				output << "  ";
			}
		}
		output << "" << endl;
	}

	Color(2);
	output << "Human =";

	output << O << "        ";
	
	Color(4);
	output << "Zombie =";
	
	output << Z << endl;

	return output;
}

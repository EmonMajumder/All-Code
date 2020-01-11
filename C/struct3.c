#include <stdio.h>

struct time {
	int hours;
	int minutes;
	int seconds;
};


struct date{
	int day;
	int month;
	int year;

};

struct datecombo {
	struct date mydate;
	struct time mytime;
};


int main() {

	struct datecombo mycombo;

	mycombo.mydate.day = 13;
	mycombo.mydate.month = 2;
	mycombo.mydate.year	= 2018;
	mycombo.mytime.hours = 12;

	printf("Struct in struct\n");
	printf("%i\t%i\n",mycombo.mydate.year, mycombo.mytime.hours);
	return 0;
}
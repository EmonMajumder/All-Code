#include <stdio.h>

struct date {
	int month;
	int day;
	int year;
};

int main() {

	struct date mydate;
	struct date yourdate;
	struct date diffdate;

	mydate.day = 13;
	mydate.month = 2;
	mydate.year = 2018;

	yourdate.day = 14;
	yourdate.month = 3;
	yourdate.year = 2018;

	printf("Hello Structures!\n");
	printf("Today is: %i/%i/%2i.\n", mydate.month,
		   mydate.day, mydate.year);
	printf("Your date is: %i/%i/%2i.\n", yourdate.month,
		   yourdate.day, yourdate.year);
	diffdate.year = yourdate.year - mydate.year;
	diffdate.month = yourdate.month - mydate.month;
	diffdate.day = yourdate.day - mydate.day;


	printf("Difference in dates is: %i months, %i days, %i years.\n", diffdate.month,
		   diffdate.day, diffdate.year);

	return 0;
}
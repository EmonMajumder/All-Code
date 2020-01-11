#include <stdio.h>
#include <stdbool.h>

struct date {
	int month;
	int day;
	int year;
};

int numberOfDays(struct date d);

bool std_leap_year(int year) {
	bool leap;

	leap = false;
	if( !(year % 4) ) {
		leap = true;
		if (year % 100 == 0) {
			leap = false;
		}
		if (year % 400 == 0) {
			leap = true;
		}

	}
	return (leap);
}


int main() {

	struct date today, tomorrow;
	today.year = 2016;
	today.month = 12;
	today.day = 31;

	if (today.day != numberOfDays (today)) {
		tomorrow.day = today.day+1;
		tomorrow.month = today.month;
		tomorrow.year = today.year;
	}
	else if (today.month == 12){
		tomorrow.day = 1;
		tomorrow.month = 1;
		tomorrow.year = today.year + 1;
	}
	else {
		tomorrow.day = 1;
		tomorrow.month = today.month + 1;
		tomorrow.year = today.year;
	}

	printf("Tomorrow will be: %i/%i/%.2i\n",
		   tomorrow.month, tomorrow.day, tomorrow.year);


	return 0;
}

int numberOfDays(struct date d){
	int days;
	bool isLeapYear;
	const int daysperMonth[12] =
		{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	isLeapYear = std_leap_year(d.year);
	if( (isLeapYear == true && d.month==2 )) days = 29;
	else
		days = daysperMonth[d.month -1];
	return days;
}
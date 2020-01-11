//
// Print number of days in a month, leap year support

#include <stdio.h>

enum month {January =1, February, March, April
			, May, June, July, August, September
			, October, November, December };

#define IS_LEAP_YEAR(year) year % 4 == 0 && year % 100 !=0 \
						|| year % 400 == 0

int main() {
	printf("Hello, World!\n");
	enum month aMonth;
	int days;
	int year;
	printf("Enter year: ");
	scanf ("%i", &year);
	printf("Enter month number: ");
	scanf ("%i", &aMonth);
	switch (aMonth){
		case January:
		case March:
		case May: 
		case July:
		case August:
		case October:
		case December:
			days = 31;
			break;
		case April:
		case June:
		case September:
		case November:
			days = 30;
			break;
		case February:
			days = 28;
			break;
		default:
			printf ("Bad month number\n");
			days =0;
			break;

	}


	if ( IS_LEAP_YEAR (year) && aMonth == February){
		days = 29;
	}


	if (days != 0)
		printf("Number of days is %i\n", days);

	if (aMonth == February)
		printf ("... or 29 if it\'s a leap year\n");

	return 0;
}
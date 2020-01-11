#include <stdio.h>
#include <string.h>

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

struct course {
	struct datecombo coursetime;
	char coursename[];
};

struct roomDaily{
	char roomCode[8];
	struct course classes[6];
	};


int main() {

	struct roomDaily thisRoom;

	strncat(thisRoom.roomCode, "D213", 4);
	strncat(thisRoom.classes[0].coursename, "PROG2007", sizeof("PROG2007"));

	thisRoom.classes[0].coursetime.mydate.day = 13;
	thisRoom.classes[0].coursetime.mydate.month = 2;
	thisRoom.classes[0].coursetime.mydate.year	= 2018;
	thisRoom.classes[0].coursetime.mytime.hours = 12;
	thisRoom.classes[0].coursetime.mytime.minutes = 30;


	printf("Nested structs\n");
	printf("Room: %s\t", thisRoom.roomCode );
	printf("Time: %i\t%i\t%i\t%i\t%i\n",
			thisRoom.classes[0].coursetime.mydate.year,
	        thisRoom.classes[0].coursetime.mydate.month,
	        thisRoom.classes[0].coursetime.mydate.day,
		    thisRoom.classes[0].coursetime.mytime.hours,
		    thisRoom.classes[0].coursetime.mytime.minutes);
	printf("Course: %s\n", thisRoom.classes[0].coursename);

	return 0;
}
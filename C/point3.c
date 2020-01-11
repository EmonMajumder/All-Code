#include <stdio.h>

void copyString(char *to, char *from){
	for (; *from != '\0'; ++from, ++to){
		*to = *from;
	}
}

int main() {
	void copyString (char *to, char *from);
	char string1[] = "A string to be copied.";
	char string2[50];
	copyString( string2, string1);
	printf("String2 is %s\n", string2);

	copyString(string2, "So is this.");
	printf("String2 now is %s\n", string2);
	printf("And String1 is still %s\n", string1);

	return 0;
}
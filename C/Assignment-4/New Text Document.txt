#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAXFNAME 64
#define ENCRYPT(x) (x ^ mask)                                       //Pre-processor macro for encryption with bitwise Exclusive Or.
#define DECRYPT(x) (x ^ mask)                                       //Pre-processor macro for encryption with bitwise Exclusive Or.

enum operation {Encrypt =1, Decrypt};                               //Enum type for encryption or decryption choice.

int main() {

    int i,j,k,asc;
    char userstr[80], decryptedstr[80], line[255], *token[255];
    unsigned int input[80];
    unsigned int output[80];

    unsigned int mask = 0xa5;                                       //encryption bitmask set up.

    enum operation encryptordecrypt;                                //enum operation type variable

    char start[]={'0','1','2','3','4','5','6','7','8','9',
                  'A','B','C','D','E','F','G','H','I','J',
                  'K','L','M','N','O','P','Q','R','S','T',
                  'U','V','W','X','Y','Z','!','@','#','$',
                  '%','&','(',')',':',';','?','.',',','/'};

    char sub[] = {':',';','?','.',',','/','0','1','2','3',
                  '4','5','6','7','8','9','A','B','C','D',
                  'E','F','G','H','I','J','K','L','M','N',
                  'O','P','Q','R','S','T','U','V','W','X',
                  'Y','Z','!','@','#','$','%','&','(',')'};

    char inName[ MAXFNAME ], outName[ MAXFNAME ];                   //variable for filename or location.
    FILE *infile, *outfile;                                         //Read and write file action variable

    printf("Encryption or Decryption?\n[1 for encryption & 2 for decryption]: ");
    scanf("%u",&encryptordecrypt);                                  //%u for unsigned int
    getchar();                                                      /*getchar take the newline character left by scanf
                                                                    so that next input function work properly*/

    switch(encryptordecrypt){                                       //switch for deciding encryption or decryption action

        case Encrypt:

            printf("Enter your message for encryption: ");
            fgets(userstr,80,stdin);                                //Take user input as string and save it in the char array.

            for(i=0;i<strlen(userstr)-1;i++){
                if(strcmp(&userstr[i]," ")==0){                     //If input character is a " "(space) it is not substituted.
                    continue;
                }
                else {
                    if(userstr[i]>='a' && userstr[i]<='z') {        //If input is small letter, convert to capital letter.
                        userstr[i] = (toupper(userstr[i]));
                    }
                    for(j=0;j<50;j++){                              //Check if the input character matches with any character in start array.
                                                                    //If matche is found it is replaced with charcter from sub array.
                        if(userstr[i]==start[j]){
                            userstr[i]=sub[j];
                            break;
                        }
                    }
                }
                asc=userstr[i];                                     //Convert the character to it's ascii value.
                output[i]=ENCRYPT(asc);                             //Bit mask the ascii value with predefined macro
            }
            for(k=0;k<strlen(userstr)-1;k++){
                printf("%i ",output[k]);
            }
            break;

        case Decrypt:

            printf("Enter your encrypted message: ");
            fgets(userstr,80,stdin);

            i=0;
            token[0] = strtok(userstr," ");                         //Strtok is used to break the user inpt string into separate strings based on " "(space).
            while (token[i] != NULL) {
                input[i]=(unsigned int)(atoi(token[i]));
                i++;
                token[i] = strtok(NULL," ");
            }

            for(j=0;j<i;j++){
                output[j]=DECRYPT(input[j]);
                decryptedstr[j]= (char)output[j];                   //Convert integers to corresponding characters by casting.

                for(int f=0;f<50;f++){
                    if(decryptedstr[j]==sub[f]){
                        decryptedstr[j]=start[f];
                        break;
                    }
                }
            }
            for (k=0;k<j;k++){
                printf("%c",decryptedstr[k]);
            }
            break;
    }

    printf("\n\n");
    printf ("Input file for encryption or decryption: ");
    scanf ("%63s", inName);                                         //read of a max of MAXFNAME characters (63 plus NULL terminator)
    printf ("Output file: ");
    scanf ("%63s", outName);

    // open the files
    if ((infile = fopen (inName, "r")) == NULL) {                   //check if the input file is readable.
        printf("Error! Cannot open input file. %s\n", inName);
        return 1; // terminate with error
    }
    if ((outfile = fopen (outName, "w")) == NULL) {                 //check if the output file is writeable.
        printf("Error! Cannot open output file. %s\n", outName);
        return 1; // terminate with error
    }

    switch(encryptordecrypt){

        case Encrypt:

            while (fgets(line, sizeof(line), infile)) {             //read line by line string from input file.
                for(i=0;i<strlen(line);i++) {
                    if (strcmp(&line[i], " ") == 0) {
                        continue;
                    } else {
                        if (line[i] >= 'a' && line[i] <= 'z') {
                            line[i] = (toupper(line[i]));
                        }
                        for (j= 0; j < 50; j++) {
                            if (line[i] == start[j]) {
                                line[i] = sub[j];
                                break;
                            }
                        }
                    }
                    asc = line[i];
                    output[i] = ENCRYPT(asc);
                    fprintf(outfile, "%i ", output[i]);
                }
                fprintf(outfile, "\n");
            }
            printf( "Encryption completed.\n");
            break;

        case Decrypt:

            while (fgets(line, sizeof(line), infile)) {

                i = 0;
                token[0] = strtok(line, " ");

                while (token[i] != NULL) {
                    input[i] = (unsigned int) (atoi(token[i]));
                    i++;
                    token[i] = strtok(NULL, " ");
                }

                for (j = 0; j < i-1; j++) {
                    output[j] = DECRYPT(input[j]);
                    userstr[j] = (char) output[j];

                    for (int f = 0; f < 50; f++) {
                        if (userstr[j] == sub[f]) {
                            userstr[j] = start[f];
                            break;
                        }
                    }
                }

                for (k = 0; k<j; k++) {
                    fprintf(outfile, "%c", userstr[k]);
                }
            }

            printf( "Decryption completed.\n");
            break;
    }

    // Close files
    fclose (infile);
    fclose (outfile);

    return 0;
}
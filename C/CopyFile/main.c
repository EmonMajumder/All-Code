#include <stdio.h>

#define MAXFNAME 64 // Max file name string size
int main() {
    char inName[ MAXFNAME ], outName[ MAXFNAME ];
    FILE *infil, *outfil;
    int c; // will actually be used to do an ASCII character by character copy of the input file

    printf ("Enter the name of the file to copy: ");
    scanf ("%63s", inName); // note read of a max of MAXFNAME characters (63 plus NULL terminator)
    printf ("Enter the name of the target file: ");
    scanf ("%63s", outName);

    // open the files
    if ((infil = fopen (inName, "r")) == NULL) {
        printf("Error! Cannot open input file. \n", inName);
        return 1; // terminate with error
    }
    if ((outfil = fopen (outName, "w")) == NULL) {
        printf("Error! Cannot open output file. \n", outName);
        return 1; // terminate with error
    }

    // Do the copy
    while ((c = getc (infil)) != EOF){
        putc(c, outfil);
    }

    // Close the files
    fclose (infil);
    fclose (outfil);

    printf( "Copy completed. \n");

    return 0;
}
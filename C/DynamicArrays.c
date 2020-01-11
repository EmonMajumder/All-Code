// DynamicArrays.c : Defines the entry point for the console application.
//

#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv) {
	int **matrix;
	// maxrow and maxcol mimic count of lines from file
	// for demo read x and y from terminal
//	int maxrow = 5; // used for debug
//	int maxcol = 4; // used for debug
	int maxrow, maxcol;
	printf("Please enter the number of rows: ");
	scanf("%i", &maxrow);
	printf("Please enter the number of columns: ");
	scanf("%i", &maxcol);


	// dynamically allocate an array
	// maxrow = number of matrix rows
	// maxcol = line length

	matrix = (int **)malloc(sizeof(int *)*maxrow);

	for (int count = 0; count < maxrow; count++)
	{
		matrix[count] = (int *)malloc(sizeof(int)*maxcol);
	}

	// load the elements in to the matrix
	printf("Now enter the element for the matrix...\n");
	for (int row = 0; row < maxrow; row++)
	{
		for (int col = 0; col < maxcol; col++)
		{
			printf("Row %d %d : ", (row + 1), (col + 1));
             scanf("%d", &matrix[row][col]);
        }
	}

	// Write them back out
	printf("Here is your matrix:\n");
	for (int row = 0; row < maxrow; row++)
	{
		for (int col = 0; col < maxcol; col++)
		{
			printf("%3i", matrix[row][col]);
			
		}
		printf("\n");
	}

	
	printf("Freeing the allocated matrix memory and terminating\n");

	// To free the dynamically allocated memory
	// Free each row pointer before freeing the array of pointers

	
	for (int row = 0; row < maxrow; row++)
	{
		free(matrix[row]);
	}
	free(matrix);

	return 0;
}

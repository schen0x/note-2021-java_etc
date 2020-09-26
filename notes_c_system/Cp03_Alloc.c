#include <stdio.h>
#include <string.h>
#define MAXLINES 5000
/* max #lines to be sorted */
char *lineptr[MAXLINES];
/* pointers to text lines */
int readlines(char *lineptr[], int nlines);
void writelines(char *lineptr[], int nlines);
void qsort(char *lineptr[], int left, int right);
/* sort input lines */
main()
{

}

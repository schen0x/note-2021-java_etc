#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <string.h>
int main(int argc, char const *argv[])
{

    char *pstr1;
    char *pstr2;
    pstr1 = "the pstr1";
    pstr2 = "the pstr2\0 more";
    printf("%s\n", pstr1);
    printf("%c\n", *pstr1);
    printf("%s\n", pstr2);
    printf("%c\n", *(pstr2 + 9));
    printf("%c\n", *(pstr2 + 10));
    printf("%c\n", *(pstr2 + 11));
    printf("%s\n", (pstr2 + 10));
    for (;;) ;
    return 0;
}
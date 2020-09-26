#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <string.h>
char *month_name(int n);
int main(int argc, char const *argv[])
{
    char *o = month_name(2);
    printf("%s\n", o);

    static char *arr2[2] = {"str 1", "str 2"}; // a list of list; arr2.type == char[] pointer;

    printf("%s\n", *arr2);
    printf("%s\n", *(arr2 + 1));
    printf("----------\n"); 

    // and **arr2.type == char.pointer;
    printf("%c\n", *(arr2 + 1)[0]);
    printf("%c\n", **(arr2 + 1));
    printf("%c\n", *(*(arr2 + 1) + 1));
    printf("----------"); 
    return 0;
}

/* month_name: return name of n-th month */
char *month_name(int n)
{
    static char *name[] = {
        "Illegal month",
        "January", "February", "March",
        "April", "May", "June",
        "July", "August", "September",
        "October", "November", "December"};
    return (n < 1 || n > 12) ? name[0] : name[n];
}
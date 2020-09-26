#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <string.h>
int main(int argc, char const *argv[])
{
    static char arr1[10] = { "a b c" };
    static char *arr2[10] = { "a", "b", "c" };
    printf("%s\n", arr1);
    printf("%d\n", sizeof(arr1)/sizeof(arr1[0]));
    printf("%s\n", *arr2);
    printf("%c\n", *arr2[0]);
    printf("----------\n");
    printf("%d\n", sizeof(*arr2)); // arr2.type == char[] Pointer
    printf("%d\n", sizeof(*arr2[0]));
    printf("%d\n", sizeof(char));
    return 0;
}
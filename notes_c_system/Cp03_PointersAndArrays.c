#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <string.h>
int main(int argc, char const *argv[])
{
    int arr[10];
    int *p;
    p = arr;
    printf("%d \n", arr);
    printf("%d \n", p);
    printf("sizeof char = %d \n", sizeof(char));
    printf("sizeof int = %d \n", sizeof(int));
    printf("sizeof long = %d \n", sizeof(long));
    char str0[0];
    printf("sizeof str0 = %d \n", sizeof(str0));
    char str1[] = "a";
    printf("sizeof \"a\" = %d \n", sizeof("a"));
    char str4[] = "abcd";
    printf("sizeof \"abcd\" = %d \n", sizeof(str4));
    printf("strlen \"abcd\" = %d \n", strlen(str4));

    printf("sizeof \"\" = %d \n", sizeof(""));
    return 0;
}
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <string.h>
struct point
{
    int x;
    int y;
} p0, p1;

int main(int argc, char const *argv[])
{
    struct point origin, *pp;
    pp = &origin;
    origin.x = 1, origin.y = 2;
    printf("%p\n", (void*)(pp)); // typeof pp == 'pointer';
    printf("%x\n", pp); // Unsigned hexadecimal integer

    printf("%d\n", pp), printf("%d\n", &(*pp).x); // same, the pointer of a struct initially point to its first element.

    printf("%d\n", *pp), printf("%d\n", origin);

    printf("------------");
    return 0;
}
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <string.h>
struct point
{
    int x;
    int y;
} p0, p1, points[] = {2, 3, 4, 5};

int main(int argc, char const *argv[])
{
    struct point origin, *pp;
    pp = &origin;
    origin.x = 1, origin.y = 2;
    printf("%p\n", (void *)(pp)); // typeof pp == 'pointer';
    printf("%x\n", pp);           // Unsigned hexadecimal integer

    printf("%d\n", pp), printf("%d\n", &(*pp).x); // same, the pointer of a struct initially point to its first element.

    printf("%d\n", *pp), printf("%d\n", origin);

    printf("------------\n");

    int ARRAY_LENGTH = 2;
    struct key
    {
        char *word;
        int count;
    } keytab[ARRAY_LENGTH]; //
    printf("keytab.length === %d \n", sizeof(keytab) / sizeof(keytab[0]));
    printf("------------\n");

    printf("%p\n", points), printf("%p\n", &points->x); // equal
    printf("%d\n", points->x);
    //! printf("%d\n", (&points)++);// illegal
    printf("%d \n", points[1].x);

    typedef struct point pointArray[];
    pointArray *pointsListPointer;
    pointsListPointer = &points;
    printf("%p\n", pointsListPointer);

    return 0;
}
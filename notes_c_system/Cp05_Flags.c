#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <string.h>
enum
{
    KEYWORD = 01,
    EXTERNAL = 02,
    STATIC = 04
};
int main(int argc, char const *argv[])
{
    unsigned int flags;
    flags &= ~(EXTERNAL | STATIC); // flags off
    flags |= EXTERNAL | STATIC;    // flags on
    // if ((flags & (EXTERNAL | STATIC)) == 0) // is true if both bits are off.

    printf("%d\n", flags);
    printf("------------\n");
    return 0;
}
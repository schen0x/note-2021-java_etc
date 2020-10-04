#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <string.h>
int main(int argc, char const *argv[])
{
    char *p0;
    char p1[] = { 'a', 'b'};
    //! printf("%d\n", *p0); // undefined behavior;
    //! printf("%c\n", *(p1++)); // the pointer itself is not mutable
    printf("------------\n");
    char p2[] = { 'a', 'b'};
    //! char *p2;
    char *p2p = p2;
    printf("%c\n", *++p2p);
    return 0;
}
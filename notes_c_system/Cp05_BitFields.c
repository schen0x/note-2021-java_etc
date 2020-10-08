#include <stdio.h>
#include <ctype.h>
struct 
{
    unsigned short icon : 8;
    unsigned short color : 4;
    unsigned short underline : 1;
    unsigned short blink : 1;
} someBitFields;

int main(int argc, char const *argv[])
{
    // TODO
    printf("%d\n", sizeof(someBitFields));
    printf("------------\n");
    return 0;
}
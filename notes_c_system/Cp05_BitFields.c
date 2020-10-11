#include <stdio.h>
#include <ctype.h>
struct s
{
    unsigned short icon : 4;
    unsigned short color : 2;
    unsigned short blink : 1;
} someBitFields; // to save space
// }__attribute__((packed)) someBitFields; // packed attribute, compiler will ignore alignment, code slower, but more packed.

#define NUM_LOOPS 20
int main(int argc, char const *argv[])
{
    for (int i = 0; i < NUM_LOOPS; i++)
    {
        someBitFields.color++;
        someBitFields.icon++;
        someBitFields.blink++;
        printf("%u, %u, %u, %u \n", someBitFields.icon, someBitFields.color, someBitFields.blink, someBitFields);
    }
    printf("%d\n", sizeof(someBitFields));
    printf("%d\n", sizeof(struct s));
    printf("------------\n");
    return 0;
}
#include <stdio.h>
#include "Cp00_Utility.h"

int bitwiseRun(){
    int i = 10;
    int j = 15;
    int o1 = i^j;
    int o2 = ~i;

    printf(" i = %d \n", i);
    printf(" i = ");
    printBits(sizeof(i), &i);
    printf("~i = %d \n", o2);
    printf("~i = ");
    printBits(sizeof(o2), &o2); // one's complement

    printf("\n");
    printf("j = ");
    printBits(sizeof(j), &j);
    printf("i^j = ");
    printBits(sizeof(o1), &o1); // XOR

    return 0;
}

int main(int argc, char const *argv[])
{
    bitwiseRun();
    return 0;
}

// gcc Cp01_Bitwise.c Cp00_AnyToBinary.c -o Cp01_Bitwise
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <string.h>
int main(int argc, char const *argv[])
{
    int n;
    printf("%Enter the size of the array\n");
    scanf("%d", &n);
    int *A = (int *)malloc(n * sizeof(int));
    for (int i = 0; i < n; i++)
    {
        A[i] = i + 1;
    }
    free(A);
    for (int i = 0; i < n; i++)
    {
        printf("A[%d] = %d\n", i, A[i]);
    }
    printf("------------\n");
    int *I = (int *)malloc(sizeof(int));
    typedef unsigned char byte;
    byte *B = (byte *)malloc(sizeof(byte));
    double *D = (double *)malloc(sizeof(double));
    printf("%x \n", I); // 5555 9ac0, 8*4 = 32 bits
    printf("%x \n", B); // 5555 9ae0
    printf("%x \n", D); // 5555 9b00

    return 0;
}
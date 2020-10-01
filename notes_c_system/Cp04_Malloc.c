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
    int *A = (int*)malloc(n*sizeof(int));
    for (int i = 0; i < n; i++){
        A[i] = i + 1;
    }
    free(A);
    for (int i = 0; i < n; i++){
    printf("A[%d] = %d\n", i, A[i]);
    }
    return 0;
}
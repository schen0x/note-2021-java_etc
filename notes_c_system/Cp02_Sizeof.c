#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <string.h>
int main(int argc, char const *argv[])
{
    int i = 2;
    printf("%d ", sizeof("12"));
    printf("%d ", sizeof(1));
    printf("%d ", sizeof(i));
    return 0;
}

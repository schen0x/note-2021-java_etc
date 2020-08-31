#include <stdio.h>

int main(int argc, char const *argv[])
{
    double nc;
    nc = 0.1;
    while (getchar() != EOF)
        // ++nc;
        printf("%lf\n", ++nc);

    return 0;
}

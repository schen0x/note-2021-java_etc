#include <stdio.h>

int main(int argc, char const *argv[])
{
    printf("%%4ld>%4ld\n", 123);
    printf("%%4lf>%4.4lf", 12345.54321);
    return 0;
}

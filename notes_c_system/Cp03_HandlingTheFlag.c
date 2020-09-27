#include <stdio.h>
#include <string.h>
#define MAXLINE 1000

main(int argc, char *argv[])
{
    char line[MAXLINE];
    long lineno = 0;
    int c, except = 0, number = 0, found = 0;
    while (--argc > 0 && (*++argv)[0] == '-')
    {
        printf("entered while, argc changed, now = %d\n", argc);
        printf("entered while, *argv[0] changed, now = %c\n", *argv[0]);
        while (c = *++argv[0])
        {
            printf("entered while2, *argv[0] changed, now = %c\n", *argv[0]);
            switch (c)
            {
            case 'x':
                except = 1;
                break;
            case 'n':
                number = 1;
                break;
            default:
                printf("find: illegal option %c\n", c);
                argc = 0;
                found = -1;
                break;
            }
        }
    }
    printf("after while, argc = %d\n", argc);
    if (argc != 1)
        printf("Usage: find -x -n pattern\n");
    else
        printf("else, argc = %d\n, use *argv(value = %s) as param\n", argc, *argv);
    return found;
}

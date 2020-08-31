#include <stdio.h>
#define MAXLINE 1000 /* maximum characters per line can handle */
int getLine(char line[], int maxline);
void arrayCopy(char to[], char from[]);

/* print the longest input line */
int main(void)
{
    int len; /* current line length */
    int max; /* maximum length seen so far */
    char line[MAXLINE]; /* current input line */
    char longest[MAXLINE]; /* longest line saved here */
    max = 0;
    while ((len = getLine(line, MAXLINE)) > 0)
        if (len > max)
        {
            max = len;
            arrayCopy(longest, line);
        }
    if (max > 0) /* there was a line */
        printf("%s", longest);
    return 0;
}

/* getLine: read a line into aLine, return length */
int getLine(char aLine[], int limit)
{
    int c, i;

    for (i = 0; i < limit - 1 && (c = getchar()) != EOF && c != '\n'; ++i)
        aLine[i] = c;
    if (c == '\n')
    {
        aLine[i] = c;
        ++i;
    }
    aLine[i] = '\0';
    return i;
}

/* arrayCopy: arrayCopy 'from' into 'to'; assume to is big enough */
void arrayCopy(char to[], char from[])
{
    int i;
    i = 0;
    while ((to[i] = from[i]) != '\0')
        ++i;
}

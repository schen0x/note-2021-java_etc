#include <stdio.h>

enum escapes
{
    BELL = '\a',
    BACKSPACE = '\b',
    TAB = '\t',
    NEWLINE = '\n',
    VTAB = '\v',
    RETURN = '\r',
    MUST_BE_INT1 = 'X',
    MUST_BE_INT2 = 89,
};

enum months {Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec}

main(int argc, char const *argv[])
{
    printf("%c", MUST_BE_INT1); // 'X'
    printf("%c", MUST_BE_INT2); // 'Y'
    printf("%d", Jan); // 0
    printf("%d", Feb); // 1

    return 0;
}

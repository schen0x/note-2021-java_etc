#include <stdio.h>

int main(int argc, char const *argv[])
{
    int i =0;
    char c = '0';
    switch(c){
        case '0': case '1':
        i++;
        break;
        case '2':{
        i += 2;
        break;
        }
        default:
        i +=3;
        break;
    }
    printf("%d", i);
    return 0;
}

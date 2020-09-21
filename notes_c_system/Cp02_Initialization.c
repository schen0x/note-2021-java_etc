#include <stdio.h>
int arr[10000000];
int main(int argc, char const *argv[])
{
    for(int i = 0; i< 1000000; i++){
        printf("%d", arr[i]);
    }
    return 0;
}

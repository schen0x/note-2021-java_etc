#include <sys/types.h>
#include <unistd.h>

int myrandom()
{
    int randomData = open("/dev/urandom");
    if (randomData < 0)
    {
        // something went wrong
    }
    else
    {
        char myRandomData[50];
        ssize_t result = read(randomData, myRandomData, sizeof myRandomData);
        if (result < 0)
        {
            // something went wrong
        }
        return result;
    }
    return -1;
}


int main(int argc, char const *argv[])
{
    // arc4random
    // char myRandomData[50];
    // arc4random_buf(myRandomData, sizeof myRandomData);

    printf("%lf", myrandom());
    // int randomData = 0;
    // // int randomData = open("/dev/urandom", O_RDONLY);
    // if (randomData < 0)
    // {
    //     // something went wrong
    // }
    // else
    // {
    //     char myRandomData[50];
    //     ssize_t result = read(randomData, myRandomData, sizeof myRandomData);
    //     if (result < 0)
    //     {
    //         // something went wrong
    //     }
    // }
    // return 0;
}

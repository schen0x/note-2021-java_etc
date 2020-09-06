#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <fcntl.h>

//TODO
int myrandom()
{
    int randomData = open("/dev/urandom", O_RDONLY);
    if (randomData < 0)
    {
        return -1;
    }
    else
    {
        int myRandomInteger;
        size_t randomDataLen = 0;
        while (randomDataLen < sizeof myRandomInteger)
        {
            ssize_t result = read(randomData, ((char *)&myRandomInteger) + randomDataLen, (sizeof myRandomInteger) - randomDataLen);
            if (result < 0)
            {
                // error, unable to read /dev/random
                return -1;
            }
            randomDataLen += result;
        }
        close(randomData);
        return myRandomInteger;
    }
}

int main(int argc, char const *argv[])
{
    printf("%d", myrandom());
}
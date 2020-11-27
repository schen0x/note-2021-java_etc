#include <iostream>

int main(int argc, char const *argv[])
{
    const int& i = 1;
    std::cout << typeid(i).name() << std::endl;
    return 0;
}

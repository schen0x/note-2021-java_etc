#include<iostream>

__declspec(dllexport) void bar()
{
    std::cout << "bar" << std::endl;
}

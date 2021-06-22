#include<iostream>

__declspec(dllexport) void foo()
{
    std::cout << "foo" << std::endl;
}

#include <iostream>
#include <vector>
#include <cstdio>

/**
 * Loop through a vector
 */
int main()
{
    std::vector<int> V = {10, 40, 20, 30};

    for (auto i : V)
    {
        std::cout << i << " ";
    }
    std::cout << std::endl;

    for (auto it = V.begin(); it != V.end(); it++)
    {
        /** to access the index as well */
        int index = it - V.begin();
        printf("value: %d (at index: %d)\n", *it, index);
    }

    return 0;
}

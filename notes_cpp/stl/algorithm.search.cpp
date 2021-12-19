#include <iostream>
#include <vector>
#include <algorithm>

template <typename T>
void printVec(std::vector<T> V)
{
    for (auto i : V)
    {
        std::cout << i << ' ';
    }
    std::cout << std::endl;
    return;
}

bool myComp(int i, int j) { return (i > j); }

/**
 * - binary_search(V.begin(), V.end(), val) // return if val exist
 * - lower_bound(V.begin(), V.end(), val)   // return first match, Greater or Equal than val
 * - upper_bound(V.begin(), V.end(), val)   // return first match, Greater than val
 */
int main()
{
    std::vector<int> V = {10, 40, 20, 30};
    sort(V.begin(), V.end()); // avg-time O(NlogN), worst-time O(NlogN); unstable; use Introsort.
    printVec<int>(V);         // 1,2,3,4
    bool present = binary_search(V.begin(), V.end(), 3);
    std::cout << present << std::endl; // 0

    // >=30
    auto firstGE30 = lower_bound(V.begin(), V.end(), 30);
    std::cout << (firstGE30 - V.begin()) << std::endl; // 2
    std::cout << *firstGE30 << std::endl;              // 30

    // > 30
    auto firstGT30 = upper_bound(V.begin(), V.end(), 30);
    std::cout << *firstGT30 << std::endl; // 40

    return 0;
}

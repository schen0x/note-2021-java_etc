#include <iostream>
#include <vector>
#include <algorithm>

void printVec(std::vector<int> V)
{
    for (auto i : V)
    {
        std::cout << i << ' ';
    }
    std::cout << std::endl;
    return;
}

bool myComp(int i, int j) { return (i > j); }

int main()
{
    std::vector<int> A = {1, 4, 2, 3};
    std::cout << A[1] << std::endl;
    sort(A.begin(), A.end()); // avg-time O(NlogN), worst-time O(NlogN); unstable; use Introsort.
    printVec(A); // 1,2,3,4
    sort(A.begin(), A.begin() + 3, myComp);
    printVec(A); // 3,2,1,4
    return 0;
}

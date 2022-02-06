#!/bin/python3

import math
import os
import random
import re
import sys
from typing import List
from bisect import insort_left, bisect_left

#
# Complete the 'cookies' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER k
#  2. INTEGER_ARRAY A
#
# def oneMix(k:int, T: List[int]) -> List[int]:
#     # T.reverse()
#     a = T[0]
#     b = T[1]
#     ab = a + 2 * b
#     T = T[2:]
#     insort_left(T, ab)
#     if len(T) > 2 and T[len(T) - 2] >= k:
#         T.pop()
#     print(T)
#     return T


# def cookies(k: int, A: List[int]):
#     # Write your code here
#     A.sort()
#     counter = 0
#     # till = bisect(A, k)
#     # if till >
#     t = bisect_left(A, k)

#     # target
#     T = A[:t+1]
#     while True:
#         if T[0] > k:
#             return counter
#         if T[0] < k and len(T) < 2:
#             return -1
#         T = oneMix(k, T)
#         print(T)
#         counter += 1

import heapq


def cookies(k, A):
    heapq.heapify(A)

    ops = 0
    while True:
        f = heapq.heappop(A)

        if f >= k:
            return ops

        if len(A) == 0:
            return -1

        s = heapq.heappop(A)
        n = f + 2 * s
        heapq.heappush(A, n)

        ops += 1


# if __name__ == '__main__':
# fptr = open(os.environ['OUTPUT_PATH'], 'w')

# first_multiple_input = input().rstrip().split()

# n = int(first_multiple_input[0].strip())

# k = int(first_multiple_input[1].strip())

# A = list(map(int, input().rstrip().split()))

# result = cookies(k, A)

# fptr.write(str(result) + '\n')

# fptr.close()

if __name__ == "__main__":
    # first_multiple_input = input().rstrip().split()

    # n = int(first_multiple_input[0].strip())

    # k = int(first_multiple_input[1].strip())

    # A = list(map(int, input().rstrip().split()))

    result = cookies(7, [1, 2, 3, 9.10, 12])

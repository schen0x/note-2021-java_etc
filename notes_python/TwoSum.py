# Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
# You may assume that each input would have exactly one solution, and you may not use the same element twice.
# You can return the answer in any order.

# Example 1:

# Input: nums = [2,7,11,15], target = 9
# Output: [0,1]
# Output: Because nums[0] + nums[1] == 9, we return [0, 1].

# Example 2:

# Input: nums = [3,2,4], target = 6
# Output: [1,2]
# Example 3:
#
# Input: nums = [3,3], target = 6
# Output: [0,1]
#
#
# Constraints:
#
# 2 <= nums.length <= 104
# -109 <= nums[i] <= 109
# -109 <= target <= 109
# Only one valid answer exists.
from typing import List
from bisect import bisect_right


class Solution:
    # def twoSum(self, nums: List[int], target: int) -> List[int]:
    #     numSorted = list(nums)
    #     numSorted.sort()
    #     ij: List[int] = []
    #     # slightLargerNumIndex = bisect_right(numSorted, target)
    #     for i in reversed(range(len(nums))):
    #         if len(ij) > 0:
    #             break
    #         for j in range(i):
    #             if (numSorted[i] + numSorted[j]) > target:
    #                 break
    #             if (numSorted[i] + numSorted[j]) == target:
    #                 ij.append(i)
    #                 ij.append(j)
    #                 break
    #     oi: int = -1
    #     oj: int = -1
    #     for i, n in enumerate(nums):
    #         if oi < 0 and n == numSorted[ij[0]]:
    #             oi = i
    #             continue
    #         if oj < 0 and n == numSorted[ij[1]]:
    #             oj = i
    #             continue

    #     return [oi, oj]

    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap: dict[int, List[int]] = {}
        for ind, num in enumerate(nums):
            if num not in hashmap:
                hashmap[num] = []
            hashmap[num].append(ind)
        for ind, num in enumerate(nums):
            complement: int = target - num
            if (complement) in hashmap:
                elmsCount = len(hashmap[complement])
                if (elmsCount > 1):
                    return [hashmap[complement][0], hashmap[complement][1]]
                if (elmsCount == 1) and num != complement:
                    return [ind, hashmap[complement][0]]
        return []



s = Solution()
print(s.twoSum([3,2,4], 6))
print(s.twoSum([-3,4,3, 90], 0))
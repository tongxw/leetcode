#
# @lc app=leetcode id=78 lang=python3
#
# [78] Subsets
#

# @lc code=start
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        size = 1 << len(nums)
        ans = []
        for i in range(size):
            list = []
            for j, num in enumerate(nums):
                if (i >> j) & 1 == 1:
                    list.append(num)
            ans.append(list)

        return ans

        # ans = []
        # def backTracking(nums: List[int], start: int, path: List[int]):
        #     ans.append(path.copy())
        #     for i in range(start, len(nums)):
        #         # print(i)
        #         path.append(nums[i])
        #         backTracking(nums, i + 1, path)
        #         path.pop()
        
        # path = []
        # backTracking(nums, 0, path)
        # return ans
# @lc code=end


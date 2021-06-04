#
# @lc app=leetcode id=26 lang=python3
#
# [26] Remove Duplicates from Sorted Array
#

# @lc code=start
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        write = 1
        read = 1
        while read < len(nums):
            if nums[write - 1] != nums[read]:
                nums[write] = nums[read]
                write += 1
            read += 1

        return write

# @lc code=end


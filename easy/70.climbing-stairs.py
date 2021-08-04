#
# @lc app=leetcode id=70 lang=python3
#
# [70] Climbing Stairs
#

# @lc code=start
class Solution:
    def climbStairs(self, n: int) -> int:
        first, second = 1, 1
        for _ in range(2, n+1):
            temp = second
            second += first
            first = temp

        return second
        
# @lc code=end


#
# @lc app=leetcode id=62 lang=python3
#
# [62] Unique Paths
#

# @lc code=start
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # dp(m, n): all possible unique paths
        # dp(i, 0) = 1
        # dp(0, j) = 1
        # dp(m, n) = dp(m-1, n) + dp(m, n-1)

        dp = [[1] * n for _ in range(m)]
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        
        return dp[m-1][n-1]
        
# @lc code=end


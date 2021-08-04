#
# @lc app=leetcode id=714 lang=python3
#
# [714] Best Time to Buy and Sell Stock with Transaction Fee
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        # dp[i][0]: profit for holding stock on ith day
        # dp[i][1]: profit for not holding stock on ith day
        #
        # dp[i][0] = max(dp[i-1][0], dp[i-1][1] - prices[i])
        # dp[i][1] = max(dp[i-1][1], dp[i-1][0] + prices[i] - fee )

        dp0, dp1 = -prices[0], 0
        for i in range(1, len(prices)):
            next0 = max(dp0, dp1 - prices[i])
            next1 = max(dp1, dp0 + prices[i] - fee)
            dp0, dp1 = next0, next1
        
        return dp1

# @lc code=end


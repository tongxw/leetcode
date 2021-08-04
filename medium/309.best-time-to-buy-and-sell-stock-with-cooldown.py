#
# @lc app=leetcode id=309 lang=python3
#
# [309] Best Time to Buy and Sell Stock with Cooldown
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/zui-jia-mai-mai-gu-piao-shi-ji-han-leng-dong-qi-4/
        # dp[i][0]: profit for holding stock
        # dp[i][1]: profit for not holding stock and next day not in cooldown
        # dp[i][2]: profit for not holding stock and next day in cooldown

        # dp[i][0]: case 1: buy stock, the profit is -prices[i]
        #                   cannot hold stock or in cooldown in yesterday
        #                   : dp[i-1][1] - prices[i],
        #           case 2: hold stock in yesterday
        #                   : dp[i-1][0]
        # so, dp[i][0] = max(dp[i-1][0], dp[i-1][1] - prices[i])
        # 
        # dp[i][1] = max(dp[i-1][1], dp[i-1][2])
        # 
        # dp[i][2]: sell stock today, the profit is price[i]
        # so, dp[i][2] = dp[i-1][0] + price[i]

        dp0, dp1, dp2 = -prices[0], 0, 0
        for i in range(1, len(prices)):
            tmp = dp0
            dp0 = max(dp0, dp1 - prices[i])
            dp1 = max(dp1, dp2)
            dp2 = tmp + prices[i]

        return max(dp1, dp2)


# @lc code=end


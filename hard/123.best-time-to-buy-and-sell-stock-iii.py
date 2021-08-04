#
# @lc app=leetcode id=123 lang=python3
#
# [123] Best Time to Buy and Sell Stock III
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profits = []

        # all profits on ith day
        minPrice = prices[0]
        for price in prices:
            minPrice = min(minPrice, price)
            profits.append(price - minPrice)
        
        # all profits after ith day
        ans = 0
        maxPrice = prices[-1]
        after_profit = 0
        for i in range(len(profits) - 1, -1, -1):
            maxPrice = max(maxPrice, prices[i])
            after_profit = max(after_profit, maxPrice - prices[i])
            ans = max(ans, profits[i] + after_profit)
        
        return ans

        
# @lc code=end


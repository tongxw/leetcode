#
# @lc app=leetcode id=122 lang=python3
#
# [122] Best Time to Buy and Sell Stock II
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        sum, oldPrice = 0, prices[0]
        for price in prices:
            profit = price - oldPrice
            if profit > 0:
                sum += profit
            oldPrice = price

        return sum

# class Solution:
#     def maxProfit(self, prices: List[int]) -> int:
        
# 		# It is impossible to sell stock on first day, set -infinity as initial value for cur_hold
#         cur_hold, cur_not_hold = -float('inf'), 0
        
#         for stock_price in prices:
            
#             prev_hold, prev_not_hold = cur_hold, cur_not_hold
            
# 			# either keep hold, or buy in stock today at stock price
#             cur_hold = max( prev_hold, prev_not_hold - stock_price )
			
# 			# either keep not-hold, or sell out stock today at stock price
#             cur_not_hold = max( prev_not_hold, prev_hold + stock_price )
            
#         # maximum profit must be in not-hold state
#         return cur_not_hold if prices else 0
# @lc code=end


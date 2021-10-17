/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 * [dp][stock][state][machine]
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        //dp = profit (status machine)
        // for each day, we have 3 status of profit
        // dp0: max profit of hold one stack
        // dp1: max profit of not cool down day and not hold stock
        // dp2: max profit of cool down day and not hold stock

        // for the day i
        // dp0(i): case1. day i-1 hold stack:  dp0(i-1)
        //         case2. buy stack at day i, so day i-1 is not cool down and hold: dp1(i-1), and the profit is -price[i]
        // so, dp0(i) = max(dp0(i-1), dp1(i-1) - price[i])

        // dp1(i): case1. day i-1 not cool down and not hold: dp1(i-1)
        //         case2. day i-1 cool down and not hold: dp2(i-1)
        // so, dp1(i) = max(dp1(i-1), dp2(i-1));

        // dp2(i): case1. i-1 hold stack and sell today: dp0(i-1) + profit(i)

        // on final days, we don't need to check dp0 (hold stock)
        // just return max(dp1, dp2)

        int dp0 = -prices[0]; // KEY: buy stock at day 0
        int dp1 = 0;
        int dp2 = 0;
        for (int price : prices) {
            int newDp0 = Math.max(dp0, dp1 - price);
            int newDp1 = Math.max(dp1, dp2);
            int newDp2 = dp0 + price;

            dp0 = newDp0;
            dp1 = newDp1;
            dp2 = newDp2;
        }

        return Math.max(dp1, dp2);
    }   
}
// @lc code=end


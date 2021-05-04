/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // time: O(n), space: O(1)
        int sumProfit = 0;
        int oldPrice = Integer.MAX_VALUE;
        for (int price: prices) {
            int curProfit = price - oldPrice;
            if (curProfit > 0) {
                sumProfit += curProfit;
            }

            oldPrice = price;
        }

        return sumProfit;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // time: O(n^2)
        // int maxProfit = 0;
        // for (int i=0; i<prices.length; i++) {
        //     for (int j=i+1; j<prices.length; j++) {
        //         maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
        //     }
        // }

        // return maxProfit;

        // one loop, do 2 things:
        // 1. find the min price
        // 2. find the max difference (profit)
        // time: O(n)
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price: prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }

        return maxProfit;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int maxMoney = 0;
        int totalPrevMoney = 0;
        for (int i=0; i<nums.length; i++) {
            // current max money in i-th house
            int curMaxMoeny = maxMoney;

            // 1. rob the i-th house => totalRobMoney + nums[i];
            // 2. do not rob => maxMoney;
            // question: do I need to rob the i-th house?
            maxMoney = Math.max(totalPrevMoney + nums[i], maxMoney);

            // current rob money
            totalPrevMoney = curMaxMoeny;
        }

        return maxMoney;
    }
}
// @lc code=end


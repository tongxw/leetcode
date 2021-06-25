/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        // dp(i): max rob from [0, i]
        // dp(0) = nums[0]
        // dp(1) = max(nums[0], nums[1])
        // dp(i) = max(dp(i-2) + nums[i], dp(i-1))
        int[] dp = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else if (i == 1) {
                dp[i] = Math.max(nums[0], nums[1]);
            } else {
                dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
            }
        }

        return dp[dp.length - 1];
    }
}
// @lc code=end


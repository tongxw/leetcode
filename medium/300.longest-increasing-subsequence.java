/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    //TODO O(nlogn) solution?
    // https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
    public int lengthOfLIS(int[] nums) {
        // dp(i): len of LIS, end with nums[i]
        // dp(i) >= 1
        // while (0 <= j < i):
        //      if (nums[i] > nums[j]): dp(i) = max(dp(j) + 1)

        int[] dp = new int[nums.length];
        for (int i=0; i<dp.length; i++) {
            dp[i] = 1;
        }

        int ans = 1;
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=673 lang=java
 *
 * [673] Number of Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int findNumberOfLIS(int[] nums) {
        // similar as #5
        // boolean dp(i, j): true if dp(i, j) is an increasing subsequence
        // dp(i,i) = true
        // dp(i, i+1) = nums[i+1] > nums[i]
        // dp(i, j) = dp(i, j-1) and nums[j] > nums[j-1]

        int n = nums.length;
        boolean[][] dp = new boolean[n][n];
        for (int i=0; i<n; i++) {
            dp[i][i] = true;
        }

        for (int subLen = 2; subLen < n; subLen++) {
            for (int i=0; i<n; i++) {
                subLen = 
            }
        }


    }
}
// @lc code=end


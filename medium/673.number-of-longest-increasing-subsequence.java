/*
 * @lc app=leetcode id=673 lang=java
 *
 * [673] Number of Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    // https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/solution/673-zui-chang-di-zeng-zi-xu-lie-de-ge-sh-g7a0/
    public int findNumberOfLIS(int[] nums) {
        // dp(i): 以nums[i]结尾的最长子序列的长度
        // count(i): 以nums[i]结尾的最长子序列的个数
        // dp(i) >=1, count(i) >= 1
        // while(0 <= j < i):
        //      if nums[i] > nums[j]:
        //          if dp(j) + 1 > dp(i) => dp(i) = dp(j) + 1, count(i) = count(j)
        //          if dp(j) + 1 = dp(i) => count(i) += count(j)

        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];

        for (int i=0; i<n; i++) {
            dp[i] = 1;
            count[i] = 1;
        }

        int maxLen = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        int ans = 0;
        for (int i=0; i<n; i++) {
            if (dp[i] == maxLen) {
                ans += count[i];
            }
        }


        return ans;
    }
}
// @lc code=end


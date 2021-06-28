/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // dp(i) = dp(i-1) + dp(i-2)
        // dp(0) = 0;
        // dp(1) = 1;
        // dp(2) = 2
        // return dp(n)
        if (n <= 1) {
            return 1;
        }

        // int[] dp = new int[n+1];
        // dp[1] = 1;
        // dp[2] = 2;

        int first = 1;
        int second = 2;
        for (int i=3; i<n+1; i++) {
            int temp = second;
            second += first;
            first = temp;
            // dp[i] = dp[i-1] + dp[i-2];
        }

        // return dp[n];
        return second;
    }
}
// @lc code=end


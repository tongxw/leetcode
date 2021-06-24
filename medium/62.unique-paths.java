/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        // dp(m, n) = dp(m-1, n) + dp(m, n-1)
        // dp(0, 0) = 0
        // dp(0, i) = 1
        // dp(i, 0) = 1
        // TC: O(m*n), SC: O(m*n)
        int[][] dp = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        
        return dp[m-1][n-1];
    }
}
// @lc code=end


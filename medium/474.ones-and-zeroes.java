/*
 * @lc app=leetcode id=474 lang=java
 *
 * [474] Ones and Zeroes
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp(i, j, k) strs[0...i], largest set where 0s < j and 1s < k
        // dp(i, j, k) not pick strs[i] = dp(i-1, j, k)
        // dp(i, j, k) pick strs[i] = dp(i-1, j - strs[i]0s, k - strs[i] 1s) + 1
        // dp(i, j, k) = max(not pick, pick)
        // dp(i, 0, 0) = 0
        // dp(0, j, k) = 1 if strs[0] 0s < j and str[0] 1s < k

        int[][][] dp = new int[strs.length][m+1][n+1];
        int zeros = countZeros(strs[0]);
        int ones = strs[0].length() - zeros;
        for (int j=0; j<=m ;j++) {
            for (int k=0; k<=n; k++) {
                if (j >= zeros && k >= ones) {
                    dp[0][j][k] = 1;
                }
            }
        }

        for (int i=1; i<strs.length; i++) {
            zeros = countZeros(strs[i]);
            ones = strs[i].length() - zeros;
            for (int j=0; j<=m ;j++) {
                for (int k=0; k<=n; k++) {
                    dp[i][j][k] = dp[i-1][j][k];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-zeros][k-ones] + 1);
                    }
                }
            }
        }

        // ["0","1"]\n1\n1
        return dp[strs.length-1][m][n];
    }

    private int countZeros(String str) {
        int count = 0;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '0') {
                count++;
            }
        }

        return count;
    }
}
// @lc code=end


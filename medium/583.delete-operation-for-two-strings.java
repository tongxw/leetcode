/*
 * @lc app=leetcode id=583 lang=java
 *
 * [583] Delete Operation for Two Strings
 */

// @lc code=start
class Solution {
    // LCS 583 712 1143
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        // dp(i, j): word1[0...i-1] and word2[0...j-1] length of LCS(longest common subsequence)
        // return len1 - dp(len1, len2) + len2 - dp(len1, len2)
        // dp(i, 0) = 0, dp(0, j) = 0;
        // if word1[i-1] == word2[j-1] : dp(i, j) = dp(i-1, j-1) + 1 
        // else:  dp(i, j) = max(dp(i-1, j), dp(i, j-1))
        int[][] dp = new int[len1+1][len2+1];
        for (int i=1; i<len1+1; i++) {
            for (int j=1; j<len2+1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int keep = dp[len1][len2];
        return len1 - keep + len2 - keep;
    }
}
// @lc code=end


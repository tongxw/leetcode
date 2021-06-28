/*
 * @lc app=leetcode id=712 lang=java
 *
 * [712] Minimum ASCII Delete Sum for Two Strings
 */

// @lc code=start
class Solution {
    // LCS 583 712 1143
    public int minimumDeleteSum(String s1, String s2) {
        // dp(i,j) = ascii sum of LCS: s1[0...i-1] and s2[0...j-1]
        // dp(i, 0) = dp(0, j) = 0
        // dp(i, j): if s1[i-1] == s2[j-1] : dp(i, j) = dp(i-1, j-1) + ascii(s1[i-1])
        //           else    : dp(i, j) = max(dp(i-1, j), dp(i, j-1))
        // return ascii(s1) - dp(len1, len2) + ascii(s2) - dp(len1, len2)
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i=1; i<len1+1; i++) {
            for (int j=1; j<len2+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + s1.charAt(i-1);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int ans = -dp[len1][len2] * 2;
        for (int i=0; i<len1; i++) {
            ans += s1.charAt(i);
        }
        for (int i=0; i<len2; i++) {
            ans += s2.charAt(i);
        }

        //""delete"\n"leet""
        return ans;
    }
}
// @lc code=end


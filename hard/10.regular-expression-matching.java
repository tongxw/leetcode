/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp(i, j) => if s[i] matches p[j]
        // dp(0, 0) = true (two empty strings)
        // dp(i, j) => 1. if p[j] == s[i] || p[j] == '.', dp(i, j) = dp(i-1, j-1);
        //          => 2. if p[j] == '*' => 2.1 => if p[j-1] != s[i] => dp(i, j) = dp(i, j-2) // 'a*' only counts as empty
        //                               => 2.2 => if p[j-1] == s[i] || p[j-1] == '.'
        //                                                 dp(i, j) = dp(i-1, j) or dp(i, j-1) or dp(i, j-2)
        
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        for (int j=1; j<=n; j++) {
          if (p.charAt(j-1) == '*') {
            dp[0][j] = dp[0][j - 2];
          }
        }
    
        for (int i=1; i<=m; i++) {
          for (int j=1; j<=n; j++) {
            char sChar = s.charAt(i-1);
            char pChar = p.charAt(j-1);
            if (pChar == sChar || pChar == '.') {
              dp[i][j] = dp[i-1][j-1];
            } else if (pChar == '*') { // j >= 2, '*' can't be in the 1st place
              if (p.charAt(j-2) == sChar || p.charAt(j-2) == '.') {
                dp[i][j] = dp[i][j-2] || dp[i-1][j] || dp[i-1][j-2];
              } else {
                dp[i][j] = dp[i][j-2];
              }
            } else {
              // dp[i][j] = false;
            }
          }
        }
        
        return dp[m][n];
    }
}
// @lc code=end


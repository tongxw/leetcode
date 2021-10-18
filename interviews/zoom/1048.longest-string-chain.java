/*
 * @lc app=leetcode id=1048 lang=java
 *
 * [1048] Longest String Chain
 */

// @lc code=start
class Solution {
    public int longestStrChain(String[] words) {
        // 重点！！！
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());
        
        // dp(i): longest word chain from words[0...i]
        int n = words.length;
        int[] dp = new int[n];
        for (int i=0; i<n; i++) {
            dp[i] = 1;
        }
        
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                // words[j] is less than words[i], so if check pass, can add words[i] to dp[j] as train
                if (check(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
    
    private boolean check(String s1, String s2) {
        if (s1.length() != s2.length() - 1) {
            return false;
        }
        
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else if (i == j) {
                j++;
            } else {
                return false;
            }
         }
        
        return true;
    }
}
// @lc code=end


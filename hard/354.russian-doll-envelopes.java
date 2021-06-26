import java.util.*;

/*
 * @lc app=leetcode id=354 lang=java
 *
 * [354] Russian Doll Envelopes
 */

// @lc code=start
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (e1, e2) -> {
            return e1[0] - e2[0];
        });
        
        // dp(i): max number of envelopes end with envelopes[i]
        // dp(i) > = 1
        // while 0 <= j < i :
        //  if e[i][0] > e[j][0] && e[i][1] > e[j][1] : dp(i) = max(dp(j) + 1)
        int[] dp = new int[envelopes.length];
        for (int i=0; i<dp.length; i++) {
            dp[i] = 1;
        }

        int ans = 1;
        for (int i=0; i<envelopes.length; i++) {
            for (int j=i-1; j>=0; j--) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            ans = Math.max(ans, dp[i]);
        }
        
        // [[1,2],[2,3],[3,4],[4,5],[5,6],[5,5],[6,7],[7,8]]
        return ans;
    }
}
// @lc code=end


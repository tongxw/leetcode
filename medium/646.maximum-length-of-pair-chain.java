import java.util.*;

/*
 * @lc app=leetcode id=646 lang=java
 *
 * [646] Maximum Length of Pair Chain
 */

// @lc code=start
class Solution {
    public int findLongestChain(int[][] pairs) {
        // LC-435 LC-646
        Arrays.sort(pairs, (p1, p2) -> {
            return p1[0] - p2[0];
        });

        // dp(i): longest chain end with pairs[i]
        // dp(i) >= 1
        // while 0 <= j < i:
        //      if pairs[i][0] > pairs[j][1] : dp(i) = max(dp(j) + 1)

        int n = pairs.length;
        int[] dp = new int[n];
        for (int i=0; i<n; i++) {
            dp[i] = 1;
        }

        int ans = 1;
        for (int i=0; i<n; i++) {
            for (int j=i-1; j>=0; j--) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    break;
                }
            }

            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}
// @lc code=end


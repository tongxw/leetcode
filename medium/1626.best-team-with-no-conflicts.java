import java.util.*;

/*
 * @lc app=leetcode id=1626 lang=java
 *
 * [1626] Best Team With No Conflicts
 */

// @lc code=start
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        // LIS (longest increasing subsequence)
        int n = scores.length;
        int[][] players = new int[n][2];
        for (int i=0; i<n; i++) {
            players[i][0] = scores[i];
            players[i][1] = ages[i];
        }

        Arrays.sort(players, (p1, p2) -> {
            if (p1[1] == p2[1]) {
                // KEY: same age, sort by scores, so LIS dp will still work
                return p1[0] - p2[0];
            } else {
                return p1[1] - p2[1];
            }
        });

        // dp(i): players[0...i], total score of LIS
        // dp(i) = players[i][0]
        // while 0 <= j < i
        //   if score[i] >= score[j] : dp(i) = max(dp(i), dp(j) + score[i])
        int[] dp = new int[n];
        for (int i=0; i<n; i++) {
            dp[i] = players[i][0];
        }

        int maxLen = 0;
        int beginIndex = 0;
        int endIndex = 0;
        int ans = 0;
        for (int i=0; i<n; i++) {
            int tmpBeginIndex = 0;
            for (int j=0; j<i; j++) {
                if (players[i][0] >= players[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + players[i][0]);
                }
            }

            // System.out.println("i: " + i + " dp: " + dp[i]);
            ans = Math.max(ans, dp[i]);
        }

        //[4,5,6,5]\n[2,1,2,1]
        //[4,5,6,5]\n[1,1,1,1]
        //[319776,611683,835240,602298,430007,574,142444,858606,734364,896074]\n[1,1,1,1,1,1,1,1,1,1]
        return ans;
    }
}
// @lc code=end


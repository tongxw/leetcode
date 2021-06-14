/*
 * @lc app=leetcode id=837 lang=java
 *
 * [837] New 21 Game
 */

// @lc code=start
class Solution {
    public double new21Game(int n, int k, int maxPts) {
        // TODO
        // https://leetcode-cn.com/problems/new-21-game/solution/xin-21dian-by-leetcode-solution/

        if (k == 0) {
            return 1.0;
        }
        double[] dp = new double[k + maxPts];
        double sum = 0.0;
        for (int i = k; i <= n && i < k + maxPts; i++) {
            dp[i] = 1.0;
            sum += dp[i];
        }

        // for (int i = k - 1; i >= 0; i--) {
        //     for (int j = 1; j <= maxPts; j++) {
        //         dp[i] += dp[i + j] / maxPts;
        //     }
        // }

        // dp[k - 1] = 1.0 * Math.min(n - k + 1, maxPts) / maxPts;
        // for (int i = k - 2; i >= 0; i--) {
        //     dp[i] = dp[i + 1] - (dp[i + maxPts + 1] - dp[i + 1]) / maxPts;
        // }

        for (int i = k - 1; i >= 0; i--) {
            dp[i] = sum / maxPts;
            sum += dp[i] - dp[i+maxPts];
        }

        return dp[0];
    }
}
// @lc code=end


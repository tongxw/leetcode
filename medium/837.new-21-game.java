/*
 * @lc app=leetcode id=837 lang=java
 *
 * [837] New 21 Game
 */

// @lc code=start
class Solution {
    public double new21Game(int n, int k, int maxPts) {
        // TODO
        // https://leetcode-cn.com/problems/new-21-game/solution/huan-you-bi-zhe-geng-jian-dan-de-ti-jie-ma-tian-ge/

        if (k == 0) {
            return 1.0;
        }
        double[] dp = new double[k + maxPts];
        double sum = 0.0;
        for (int i = k; i <= n && i < k + maxPts; i++) {
            dp[i] = 1.0;
            sum += dp[i];
        }

        for (int i = k - 1; i >= 0; i--) {
            dp[i] = sum / maxPts;
            sum += dp[i] - dp[i+maxPts];
        }

        return dp[0];
    }
}
// @lc code=end


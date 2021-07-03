/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change 2
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        // dp(i, j): coins[0...i] numbers of combinations that make up to j
        // dp(i, j): not pick coins[i], = dp(i-1, j)
        // dp(i, j): pick coins[i], dp(i, j - coins[i]) + 1
        // dp(i, 0) = 0
        // dp(0, j) = 1 if j mod coins[0] == 0, otherwise 0

        int[] dp = new int[amount+1];
        dp[0] = 1;

        for (int j=1; j<=amount; j++) {
            if (j % coins[0] == 0) {
                dp[j] = 1;
            }
        }

        for (int i=1; i<coins.length; i++) {
            for (int j=1; j<=amount; j++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j-coins[i]];
                }
            }
        }

        return dp[amount];
    }

    private int dpSolution(int amount, int[] coins) {
        // dp(i, j): coins[0...i] numbers of combinations that make up to j
        // dp(i, j): not pick coins[i], = dp(i-1, j)
        // dp(i, j): pick coins[i], dp(i, j - coins[i]) + 1
        // dp(i, 0) = 0
        // dp(0, j) = 1 if j mod coins[0] == 0, otherwise 0

        int[][] dp = new int[coins.length][amount+1];
        for (int i=0; i<coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int j=1; j<=amount; j++) {
            if (j % coins[0] == 0) {
                dp[0][j] = 1;
            }
        }

        for (int i=1; i<coins.length; i++) {
            for (int j=1; j<=amount; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= coins[i]) {
                    dp[i][j] += dp[i][j-coins[i]];
                }
            }
        }

        return dp[coins.length - 1][amount];
    }
}
// @lc code=end


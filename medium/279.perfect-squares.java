import java.util.Arrays;

/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int sqrt = (int)Math.sqrt((double)n);
        // System.out.println(sqrt);
        // same as 322 coin change
        // nums = {1, 4, 9, ... sqrt^2}
        // dp(i, j): least numbers from nums[0..i] that sum to j
        // dp(i, j): not pick nums[i], =  dp(i-1, j)
        //            pick nums[i], = dp(i, j-nums[i])
        //            = min(pick, not pick)
        // dp(0, j) = j
        // dp(i, 1) = 1
        int[] dp = new int[n+1];
        for (int j=0; j<=n; j++) {
            dp[j] = j;
        }

        for (int i=1; i<=sqrt; i++) {
            for (int j=1; j<=n; j++) {
                if (j >= i*i) {
                    dp[j] = Math.min(dp[j], dp[j - i*i] + 1);
                }
            }
        }

        return dp[n];
    }
}
// @lc code=end


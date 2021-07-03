import java.util.Arrays;

/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    // TODO
    public int coinChange(int[] coins, int amount) {
        // dp(i, j): how many coins from[0...i] for the amount j
        // return dp(len(coins) - 1, amount)
        // TC: 2^len(coins) * (amount + 1)
        // dp(i, 0) = 0
        // dp(0, j) = (j / coins[0]) if j mod coins[0] == 0, or 0
        // dp(1, j) = 
        // if (amount == 0) {
        //     return 0;
        // }

        int[] dp1 = new int[amount + 1];
        Arrays.fill(dp1, amount + 1);
        dp1[0] = 0;

        for (int i=0; i<=amount; i++) {
            if (i % coins[0] == 0) {
                dp1[i] = i / coins[0];
            }
        }

        for (int i=1; i<coins.length; i++) {
            for (int j=1; j<=amount; j++) {
                // do not pick i
                // dp1[j] = dp1[j];

                // pick i
                if (j - coins[i] >= 0) {
                    dp1[j] = Math.min(dp1[j], dp1[j - coins[i]] + 1);
                }
            }
        }

        //[2,5,10,1]\n27
        //[186,419,83,408]\n6249
        return dp1[amount] > amount ? -1 : dp1[amount];
    }

    private int dpSolution(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];

        for (int i=0; i<coins.length; i++) {
            Arrays.fill(dp[i], amount + 1);
            dp[i][0] = 0;
        }
        for (int j=0; j<=amount; j++) {
            if (j % coins[0] == 0) {
                dp[0][j] = j / coins[0];
            }
        }

        for (int i=1; i<coins.length; i++) {
            System.out.print("coin: " + coins[i] + " ");
            for (int j=1; j<=amount; j++) {
                // do not pick i
                dp[i][j] = dp[i-1][j];

                // pick i
                if (j - coins[i] >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i]] + 1);
                }
            }
            System.out.println("");
        }



        //[2,5,10,1]\n27
        //[186,419,83,408]\n6249
        int ans = dp[coins.length - 1][amount];
        return ans > amount ? -1 : ans;
    }


    // check all possible permutations of coins array
    private int dfs(int[] coins, int amount, Map<Integer, Integer> memo) {
        if (amount < 0) {
            return -1;
        } else if (amount == 0) {
            return 0;
        }
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int ans = -1;
        for (int i=0; i<coins.length; i++) {
            int total = dfs(coins, amount-coins[i], memo);
            if (total >= 0) {
                ans = (ans == -1) ? total + 1 : Math.min(ans, total + 1);
            }
        }

        memo.put(amount, ans);
        return ans;
    }
}
// @lc code=end


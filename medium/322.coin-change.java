/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    // TODO
    public int coinChange(int[] coins, int amount) {
        // dp(i, j): how many coins from coins[0...i] for the amount j
        // return dp(len(coins) - 1, amount)
        // TC: 2^len(coins) * (amount + 1)
        // dp(i, 0) = 0
        // dp(0, j) = (j / coins[0]) if j mod coins[0] == 0, or 0
        // dp(1, j) = 


        // [1,2,5]\n100
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(coins, amount, memo);
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


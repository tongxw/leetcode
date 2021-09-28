import java.util.HashMap;

/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 * [tree]
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        //https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution/

        // define dp(n) = total number of bst from [1...n]
        // pick i from [1...n], let i to be the root,
        // say F(i, n) is the total number of bst, where the root node i, l-child is [1...i-1], r-child is [i+1...n]
        // total number of l-child bst is G(i-1), while total number of r-child bst is G(n-i)
        // so, F(i, n) = dp(i-1) * dp(n-i)
        // dp(n) = F(1, n) + F(2, n) + .... F(n, n)
        // dp(0) = 1, dp(1) = 1

        // int[] dp = new int[n+1];
        // dp[0] = 1;
        // dp[1] = 1;
        // for (int k=2; k<=n; k++) {
        //     for (int i=1; i<=k; i++) {
        //         dp[k] += dp[i-1] * dp[k-i];
        //     }
        // }


        // return dp[n];

        HashMap<Integer, Integer> memo = new HashMap<>();
        return numTreesRecur(n, memo);
    }

    private int numTreesRecur(int n, HashMap<Integer, Integer> memo) {
        if (n <= 1) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int ans = 0;
        for (int i=1; i<=n; i++) {
            ans += numTreesRecur(i-1, memo) * numTreesRecur(n - i, memo);
        }

        memo.put(n, ans);
        return ans;
    }
}
// @lc code=end


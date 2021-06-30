import java.util.Map;

/*
 * @lc app=leetcode id=464 lang=java
 *
 * [464] Can I Win
 */

// @lc code=start
class Solution {
    // private int count = 0;
    // private boolean firstPlayerTurn = true;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }

        if (sum(maxChoosableInteger) < desiredTotal) {
            return false;
        }

        // 10\n40
        // 20\n210
        Map<Integer, Boolean> memo = new HashMap<>(); // or, Boolean[] memo = new Boolean[(1 << maxChoosableInteger) - 1]
        boolean ans = dfs(maxChoosableInteger, 0, desiredTotal, 0, memo);
        // System.out.println("count : " + count);
        System.out.println(memo.size());
        return ans;
    }

    private boolean dfs(int maxChoosableInteger, int total, int desiredTotal, int picked, Map<Integer, Boolean> memo) {
        if (total >= desiredTotal) {
            return true;
        }

        if (memo.containsKey(picked)) {
            return memo.get(picked);
        }

        // count++;

        for (int i=1; i<=maxChoosableInteger; i++) {
            if ((picked & (1 << i)) != 0) {
                continue;
            } 

            // KEY: total + i >= desiredTotal
            if (total + i >= desiredTotal || !dfs(maxChoosableInteger, total + i, desiredTotal, picked | (1 << i), memo)) {
                memo.put(picked, true);
                return true;
            }
        }

        memo.put(picked, false);
        return false;
    }

    private int sum(int n) {
        return n * (n + 1) / 2;
    }
}
// @lc code=end


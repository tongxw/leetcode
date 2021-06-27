/*
 * @lc app=leetcode id=960 lang=java
 *
 * [960] Delete Columns to Make Sorted III
 */

// @lc code=start
class Solution {
    public int minDeletionSize(String[] strs) {
        // dp(i): rows[0...i] length of LIS (longest increasing sequence) for all rows
        // dp(i) >= 1
        // while 0 <= j < i:
        //   if (for all strs, str[i] > str[j] : dp(i) = max(dp(j) + 1)
        // length of LIS = max(dp(i))
        // return strs[0].length - max(dp(i))
        int len = strs[0].length();
        int[] dp = new int[len];

        for (int i=0; i<len; i++) {
            dp[i] = 1;
        }

        // TC: O(n^3)
        int keep = 1;
        for (int i=0; i<len; i++) {
            for (int j=0; j<i; j++) {
                if (isLISInAllStrs(strs, i, j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            keep = Math.max(keep, dp[i]);
        }

        // ["aaa","aaa","aaa"]
        return len - keep;
    }

    private boolean isLISInAllStrs(String[] strs, int i, int j) {
        for (String str : strs) {
            if (str.charAt(i) < str.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end


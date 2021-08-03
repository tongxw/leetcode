/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i=0; i<=n; i++) {
            // ans[i >> 1]: all digit except the last one
            // i & 1: last digit
            ans[i] = ans[i >> 1] + (i & 1);

            // int num = i;
            // while (num != 0) {
            //     ans[i]++;
            //     num = num & (num - 1);
            // }
        }

        return ans;
    }
}
// @lc code=end


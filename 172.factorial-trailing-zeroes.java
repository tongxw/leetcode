/*
 * @lc app=leetcode id=172 lang=java
 *
 * [172] Factorial Trailing Zeroes
 */

// @lc code=start
class Solution {
    public int trailingZeroes(int n) {
        // how many "5"s when factoring n?
        // counter = n/5 + n/(5^2) + n/(5^3) + ...
        int res = 0;
        while (n >= 5) {
            n /=5;
            res += n;
        }

        return res;
    }
}
// @lc code=end


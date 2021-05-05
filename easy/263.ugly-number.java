/*
 * @lc app=leetcode id=263 lang=java
 *
 * [263] Ugly Number
 */

// @lc code=start
class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        n = devide(n, 2);
        n = devide(n, 3);
        n = devide(n, 5);

        return n == 1;
    }
    private int devide(int n, int devider) {
        while (n % devider == 0) {
            n = n / devider;
        }
        return n;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=371 lang=java
 *
 * [371] Sum of Two Integers
 */

// @lc code=start
class Solution {
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        // 1. caculate add by xor, do not consider carry, say x = a xor b
        // 2. then caculate carry, and move it left, say y = (a and b) << 1
        // if y == 0, then return x
        // else, do step 1 and 2 to calculate x + y
        while (b != 0) {
            int carry = a & b;

            // add without carry
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }
}
// @lc code=end


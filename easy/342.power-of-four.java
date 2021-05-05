/*
 * @lc app=leetcode id=342 lang=java
 *
 * [342] Power of Four
 */

// @lc code=start
class Solution {
    public boolean isPowerOfFour(int n) {
        // if (n == 0) {
        //     return false;
        // }
        // while (n % 4 == 0) {
        //     n = n / 4;
        // }

        // return n == 1;

        // num can be devided by 2 and (num-1) can be devided by 3
        // return n > 0 && (n & (n - 1)) == 0 && (n - 1) % 3 == 0;


        if (n == 1) return true;
        if (n < 4) return false;

        // can be devided by 2
        if ((n & (n - 1)) != 0) return false;

        // the bit for the power of 4, must be in odd place
        // for example,
        // 16 ==> 10000 ('1' at bit 5)
        // 64 ==> 1000000 ('1' at bit 7)
        // so, n & '01010101010101010101010101010101' == n if n is power of 4.

        return (n & 0b01010101010101010101010101010101) == n;
    }
}
// @lc code=end


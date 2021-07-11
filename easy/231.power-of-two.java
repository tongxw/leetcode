/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        boolean found = false;
        while (n != 0) {
            if ((n & 1) == 1) {
                if (found) {
                    return false;
                }

                found = true;
            }

            n >>= 1;
        }

        return found;
        
    }

    public boolean IntegerBitCount(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }
}
// @lc code=end


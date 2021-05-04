/*
 * @lc app=leetcode id=191 lang=java
 *
 * [191] Number of 1 Bits
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // int sum = 0;
        // for (int i=0; i<32; i++) {
        //     sum += n & 1;
        //     n = n>>1;
        // }

        // return sum;

        // n & (n-1) can remove the last 1 in the bit format
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n-1);
        }

        return count;
    }
}
// @lc code=end

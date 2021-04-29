/*
 * @lc app=leetcode id=190 lang=java
 *
 * [190] Reverse Bits
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // // brute force
        // int[] bits = new int[32];
        // for (int i=bits.length - 1; i>=0; i--) {
        //     if (n != 0) {
        //         bits[i] = n % 2;
        //         n /= 2;
        //     } else {
        //         n = 0;
        //     }
        // }

        // int res = 0;
        // for (int i=0; i<bits.length; i++) {
        //     if (bits[i] == 1) {
        //         res += (int)Math.pow(2, i+1);
        //     }
        // }

        // return res;
        

        // Bitwise operation
        // move input "n" to the right, while move the result "res" to left
        // then return "res"
        int res = 0;
        for (int i=0; i<32; i++) {
            res = res << 1;
            if ((n & 1) == 1) {
                // the last bit is "1"
                res++;
            }
            n = n >> 1;
        }

        return res;

    }
}
// @lc code=end


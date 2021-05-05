/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // int count = 0;
        // for (int i=nums.length - 1; i>=0; i--) {
        //     if (nums[i] == 0) {
        //         ++count;
        //         for (int j=i+1; j<nums.length-count; j++) {
        //             nums[j-1] = nums[j];
        //         }
        //         nums[nums.length - count] = 0;
        //     }
        // }

        // two indexes (pointer)
        int write = 0;
        for (int read=0; read<nums.length; read++) {
            if (nums[read] != 0) {
                nums[write++] = nums[read];
            }
        }

        for (int i=write; i<nums.length; i++) {
            nums[i] = 0;
        }
    }
}
// @lc code=end


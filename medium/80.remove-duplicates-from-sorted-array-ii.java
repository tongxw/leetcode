/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 2;
        int write = k;
        for (int read = k; read < nums.length; read++) {
            // if (nums[read] != nums[write - k]) {
            //     nums[write] = nums[read];
            //     write++;
            // }
            if (nums[read] == nums[write - k]) {
                // the number in the (read) pos is the same as the last k numbers just written in the array
                // we cannot move the write pos, or there will be K+1 duplicated numbers.
            } else {
                nums[write] = nums[read];
                write++;
            }
        }

        return write;
        
    }
}
// @lc code=end


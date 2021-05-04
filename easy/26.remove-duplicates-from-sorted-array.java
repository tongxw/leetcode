/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int slow = 1;
        for (int fast=1; fast<nums.length; fast++) {
            if (nums[fast] != nums[fast-1]) {
                nums[slow++] = nums[fast];
            }
        }

        return slow;
    }
}
// @lc code=end


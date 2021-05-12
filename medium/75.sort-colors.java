/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        // time O(n) space O(n)
        int pos = 0;

        // swap all 0s to the front
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[pos];
                nums[pos++] = tmp;
            }
        }

        // swap all 1s after 0s
        for (int i=pos; i<nums.length; i++) {
            if (nums[i] == 1) {
                int tmp = nums[i];
                nums[i] = nums[pos];
                nums[pos++] = tmp;
            }
        }
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        // 0s: [0, p0)
        // 1s: [p0, i)
        // 2s: (p2, len-1]
        // the loop ends when i > p2
        int i = 0;
        int p0 = 0;
        int p2 = nums.length - 1;

        while (i <= p2) {
            if (nums[i] == 0) {
                if (i > p0) {
                    // all nums[index < p0 - 1]
                    //[0, 0, 0, ...., 0, (p0 here =>)1,....]
                    swap(nums, p0, i);
                    p0++;
                } else if (i == p0) {
                    p0++;
                }
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                // [...., x(<== p2 here), 2, 2,..., 2]
                swap(nums, i, p2);
                p2--;
            }
        }
    }

    private void Solution1(int[] nums) {
        // time O(n) space O(n)
        int pos = 0;

        // swap all 0s to the front
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, pos++);
            }
        }

        // swap all 1s after 0s
        for (int i=pos; i<nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, pos++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end


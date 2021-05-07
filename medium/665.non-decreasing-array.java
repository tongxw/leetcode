import java.util.HashMap;

/*
 * @lc app=leetcode id=665 lang=java
 *
 * [665] Non-decreasing Array
 */

// @lc code=start
class Solution {
    public boolean checkPossibility(int[] nums) {
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (nums.length == 0 || nums.length == 1) {
            return true;
        }
    
        int count = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                count++;
                if (count > 1) {
                    return false;
                }

                // key point: change this array
                if (i>=2 && nums[i] < nums[i-2]) {
                    nums[i] = nums[i-1];
                }
            }
        }

        return true;
    }
}
// @lc code=end


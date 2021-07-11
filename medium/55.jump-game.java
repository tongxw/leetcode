/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int furthest = 0;
        int end = 0;
        for (int i=0; i<nums.length; i++) {
            furthest = Math.max(furthest, i + nums[i]);
            if (i == end) {
                // if (end > furthest) {
                //     System.out.println("i:" + i + " end:" + end + " furthest:" + furthest);
                //     return false;
                // }
                end = furthest;
            }
            if (i > end) {
                return false;
            }
            // System.out.println("i:" + i + " end:" + end + " furthest:" + furthest);
        }

        // [0,2,3]
        // [3,2,1,0,4]
        // return furthest >= nums.length - 1;
        return true;
    }
}
// @lc code=end


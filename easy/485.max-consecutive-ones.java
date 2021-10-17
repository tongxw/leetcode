/*
 * @lc app=leetcode id=485 lang=java
 *
 * [485] Max Consecutive Ones
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int count = 0;
        for (int num : nums) {
            count = (num == 0) ? 0 : count + 1;
            ans = Math.max(ans, count);
        }

        return ans;
    }
}
// @lc code=end


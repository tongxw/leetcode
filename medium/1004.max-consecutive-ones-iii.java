/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int ans = 0;
        int count0 = 0;
        for (int r=0; r<nums.length; r++) {
            if (nums[r] == 0) {
                count0++;
            }
            while (count0 > k) {
                if (nums[l] == 0) {
                    count0--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
// @lc code=end


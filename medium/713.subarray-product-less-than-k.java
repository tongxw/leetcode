/*
 * @lc app=leetcode id=713 lang=java
 *
 * [713] Subarray Product Less Than K
 */

// @lc code=start
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int l = 0;
        int product = 1;
        for (int r=0; r<nums.length; r++) {
            product *= nums[r];
            while (product >= k && l <= r) {
                product /= nums[l];
                l++;
            }
            ans += r - l + 1;
        }
        
        return ans;
    }
}
// @lc code=end


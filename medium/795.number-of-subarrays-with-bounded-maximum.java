/*
 * @lc app=leetcode id=795 lang=java
 *
 * [795] Number of Subarrays with Bounded Maximum
 */

// @lc code=start
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {

        // return atMostK(nums, right) - atMostK(nums, left - 1);
        return atMostKSlidingWin(nums, right) - atMostKSlidingWin(nums, left - 1);
    }

    private int atMostK(int[] nums, int k) {
        int ans = 0;
        int pre = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] <= k) {
                pre += 1;
            } else {
                pre = 0;
            }

            ans += pre;
        }

        return ans;
    }

    private int atMostKSlidingWin(int[] nums, int k) {
        int ans = 0;
        int l = 0;
        for (int r=0; r<nums.length; r++) {
            if (nums[r] > k) {
                if (r == nums.length - 1) {
                    break;
                }
                l = r + 1;
            } else {
                ans += r - l + 1;
            }
        }

        return ans;
    }
}
// @lc code=end


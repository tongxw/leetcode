/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = nums.length + 1;

        // slide window
        // keep calculating the sum in the window
        // and move the right side and left side
        int l = 0;
        int totalFromLtoR = 0;
        for (int r=0; r<nums.length; r++) {
            totalFromLtoR += nums[r];
            while (totalFromLtoR >= target) {
                ans = Math.min(ans, r-l+1);
                totalFromLtoR -= nums[l];
                l++;
            }
        }

        // 11\n[1,2,3,4,5]
        return ans == nums.length + 1 ? 0 : ans;
    }

    private int getSum(int[] nums, int l, int r) {
        int sum = 0;
        for (int i=l; i<=r; i++) {
            sum += nums[i];
        }

        return sum;
    }

    // time O(n2)
    private int bruteForce(int target, int[] nums) {
        int ans = nums.length + 1;
        for (int i=0; i<nums.length; i++) {
            for (int j=i; j<nums.length; j++) {
                int sum = getSum(nums, i, j);
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                }
            }

        }

        // 11\n[1,2,3,4,5]
        return ans == nums.length + 1 ? 0 : ans;
    }
}
// @lc code=end


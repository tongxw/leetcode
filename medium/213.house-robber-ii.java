/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        // same as 198
        // dp(i) = max(dp(i-2) + nums[i], dp(i-1))

        // n = nums.length
        // 如果不偷窃最后一间房屋，则偷窃房屋的下标范围是 [0, n-2];
        // 如果不偷窃第一间房屋，则偷窃房屋的下标范围是 [1, n-1]
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // [1,2,3,1]
        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
    }

    // #198
    private int robRange(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start+1]);
        for (int i=start+2; i<=end; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }

        return second;
    }
}
// @lc code=end


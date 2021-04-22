/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // dynamic program
        // int maxSum = nums[0];
        // int curMaxSum = nums[0];
        // for (int i=1; i<nums.length; i++) {
        //     curMaxSum = Math.max(nums[i], curMaxSum + nums[i]);
        //     maxSum = Math.max(curMaxSum, maxSum);
        // }

        // pre-sum
        int maxSum = nums[0]; // max of all (preSum - minPreSum)
        int preSum = 0; // sum from 0 to i
        int minPreSum = 0; // min of all preSum from 0 to i-1
        for (int i=0; i<nums.length; i++) {
            preSum += nums[i];

            // update maxSum for this loop
            maxSum = Math.max(maxSum, preSum - minPreSum);

            // update min of preSum for next (i+1) loop
            minPreSum = Math.min(minPreSum, preSum);
        }

        return maxSum;
    }
}
// @lc code=end


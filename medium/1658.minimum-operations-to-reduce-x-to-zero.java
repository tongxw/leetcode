/*
 * @lc app=leetcode id=1658 lang=java
 *
 * [1658] Minimum Operations to Reduce X to Zero
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums, int x) {
        return slideWindow(nums, x);
        
        //dp solution TBD...
    }

    private int slideWindow(int[] nums, int x) {
        int sum = Arrays.stream(nums).sum();
        // we need to find the longest sub array where the total sum is (sum - x)
        int ans = -1;
        int l = 0;
        int target = 0;
        for (int r=0; r<nums.length; r++) {
            target += nums[r];
            while (target > sum - x && l <= r) {
                target -= nums[l];
                l++;
            }

            if (target == sum - x) {
                ans = Math.max(ans, r - l + 1);
            }
        }

        return ans == -1 ? ans : nums.length - ans;
    }
}
// @lc code=end


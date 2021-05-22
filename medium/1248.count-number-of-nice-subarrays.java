/*
 * @lc app=leetcode id=1248 lang=java
 *
 * [1248] Count Number of Nice Subarrays
 */

// @lc code=start
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostOddK(nums, k) - atMostOddK(nums, k - 1);
    }

    private int atMostOddK(int[] nums, int k) {
        int ans = 0;
        int l = 0;
        for (int r=0; r<nums.length; r++) {
            k -= nums[r] & 1;
            while (k < 0) {
                k += nums[l] & 1;
                l++;
            }

            ans += r - l + 1;
        }

        return ans;
    }
}
// @lc code=end


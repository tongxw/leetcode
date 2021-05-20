/*
 * @lc app=leetcode id=930 lang=java
 *
 * [930] Binary Subarrays With Sum
 */

// @lc code=start
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // int l = 0;
        // int sum = 0;
        // int ans = 0;
        // for (int r=0; r<nums.length; r++) {
        //     sum += nums[r];
        //     while (sum > goal) {
        //         sum -= nums[l];
        //         l++;
        //     }
        //     if (sum == goal) {
        //         System.out.println("l: " + l + "r: " + r);
        //         // ans++;

        //         if (r == nums.length - 1) {
        //             while (sum == goal && l <= r) {
        //                 sum -= nums[l];
        //                 l++;
        //                 ans++;
        //             }
        //         } else {
        //             ans++;
        //         }
        //     }
        // }

        // //[0,0,0,0,0]\n0
        // return ans;

        return atMostK(nums, goal) - atMostK(nums, goal - 1);
        
    }

    // choose at most k of 1s in nums
    private int atMostK(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        int ans = 0;
        int l = 0;
        int sum = 0;
        for (int r=0; r<nums.length; r++) {
            sum += nums[r];
            while (sum > k) {
                sum -= nums[l];
                l++;
            }

            // for all the windows (l, r), in which (sum <= k), they are all answers
            ans += r - l + 1;
        }

        return ans;
    }
}
// @lc code=end


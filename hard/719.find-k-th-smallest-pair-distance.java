import java.util.*;

/*
 * @lc app=leetcode id=719 lang=java
 *
 * [719] Find K-th Smallest Pair Distance
 */

// @lc code=start
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int diffMin = 0;
        int diffMax = nums[nums.length - 1] - nums[0];
        while (diffMin <= diffMax) {
            int diffMid = (diffMin + diffMax) / 2;
            // System.out.println("diffMin: " + diffMin + " diffMax:" + diffMax);
            if (countNoBigger(nums, diffMid) < k) {
                diffMin = diffMid + 1;
            } else {
                diffMax = diffMid - 1;
            }
        }

        //[1,1,1]\n2
        return diffMin;
    }

    private long countNoBigger(int[] nums, int targetDiff) {
        int l = 0;
        long counter = 0;
        for (int r=1; r<nums.length; r++) {
            while (nums[r] - nums[l] > targetDiff) {
                l++;
            }

            counter += r - l;
        }

        // System.out.println("diffMid: " + targetDiff + " counter:" + counter);
        return counter;
    } 
}
// @lc code=end


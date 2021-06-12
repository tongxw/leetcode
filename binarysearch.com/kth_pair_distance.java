import java.util.*;

class Solution {
    public int solve(int[] nums, int k) {
        Arrays.sort(nums);
        int absMin = 0;
        int absMax = nums[nums.length-1] - nums[0];

        while (absMin <= absMax) {
            int absMid = (absMin + absMax) / 2;
            if (count(nums, absMid) > k) {
                absMax = absMid - 1;
            } else {
                absMin = absMid + 1;
            }
        }

        return absMin;
    }

    private long count(int[] nums, int targetDiff) {
        // how many pairs abs(diff) <= target?
        long counter = 0;

        // sliding window
        int l = 0;
        for (int r=1; r<nums.length; r++) {
            while (nums[r] - nums[l] > targetDiff) {
                l++;
            }

            counter += r - l;
        }

        // System.out.println("diff: " + targetDiff + " counter: " + counter);
        return counter;
    }
}
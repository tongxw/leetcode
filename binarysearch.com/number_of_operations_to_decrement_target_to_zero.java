import java.util.*;

// https://binarysearch.com/problems/Number-of-Operations-to-Decrement-Target-to-Zero
class Solution {
    public int solve(int[] nums, int target) {
        //return bruteForce(nums, 0, nums.length-1, target);
        if (target == 0) {
            return 0;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum - target < 0) {
            return -1;
        }

        int ans = -1;
        int l = 0;
        int r = 0;
        int winSum = 0;
        for (r=0; r<nums.length; r++) {
            winSum += nums[r];
            while (winSum > sum - target) {
                winSum -= nums[l];
                l++;
            }
            if (winSum == sum - target) {
                ans = Math.max(ans, r - l + 1);
            }
        }

        return ans == -1 ? -1 : nums.length - ans;
    }

    private int bruteForce(int[] nums, int start, int end, int target) {

        if (target == 0) {
            return 0;
        } else if (target < 0 || start >= nums.length || end < 0 || start > end) {
            return -1;
        }


        int tryFromStart = bruteForce(nums, start + 1, end, target - nums[start]);
        int tryFromEnd = bruteForce(nums, start, end - 1, target - nums[end]);
        if (tryFromStart >= 0 && tryFromEnd >= 0) {
            return 1 + Math.min(tryFromStart, tryFromEnd);
        } else if (tryFromStart >= 0) {
            return 1 + tryFromStart;
        } else if (tryFromEnd >= 0) {
            return 1 + tryFromEnd;
        } else {
            return -1;
        }

    }
}
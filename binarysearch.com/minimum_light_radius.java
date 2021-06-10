import java.util.*;

// https://binarysearch.com/problems/Minimum-Light-Radius

class Solution {
    public double solve(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        double left = nums[0];
        double right = nums[nums.length-1];

        double firstLightPos = right;
        int count = 0;
        while (Double.compare(left, right) <= 0 && count < 20) {
            double mid = left + (double)((right - left) / 2);
            if (isValidLightPos(nums, mid)) {
                firstLightPos = Double.compare(firstLightPos, mid) < 0 ? firstLightPos : mid;
                right = mid;
            } else {
                left = mid;
            }

            count++;
        }

        return firstLightPos - nums[0];
    }

    private boolean isValidLightPos(int[] nums, double lightPos) {
        double r = lightPos - nums[0];
        int lightCount = 1;
        for (int num : nums) {
            double dist = Math.abs(num - lightPos);
            if (Double.compare(dist, r) > 0) {
                // too far away, setup a new light at this house
                if (lightCount == 3) {
                    return false;
                } else {
                    lightCount++;
                    lightPos = num + r;
                }
            }
        }

        return true;
    }
}
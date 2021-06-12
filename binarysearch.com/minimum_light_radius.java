import java.util.*;

// https://binarysearch.com/problems/Minimum-Light-Radius

class Solution {
    public double solve(int[] nums) 
        Arrays.sort(nums);

        // diameter min and max
        int dMin = 0;
        int dMax = nums[nums.length - 1] - nums[0];

        int ans = 0;
        while (dMin <= dMax) {
            int mid = (dMin + dMax) / 2;
            if (isValidDiameter(nums, mid)) {
                ans = mid;
                dMax = mid - 1;
            } else {
                dMin = mid + 1;
            }
        }

        // return (double)ans / 2;
        return (ans + 0.0) / 2;
    }

    private boolean isValidDiameter(int[] nums, int d) {
        int start = nums[0];
        int end = start + d;
        int count = 1;
        for (int num : nums) {
            if (num > end) {
                if (count == 3) {
                    return false;
                } else {
                    start = num;
                    end = start + d;
                    count++;
                }
            }
        }

        return true;
    }

    private double firstSolution(int[] nums) {
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
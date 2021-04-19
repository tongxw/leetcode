// https://leetcode.com/problems/two-sum/
import java.util.*;

public class Solution {
    // brute force time: O(n^2) space O(n)
    private int[] twoSum1(int[] nums, int target) {
        int result[] = new int[]{0, 1};
        for (int i=0; i< nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        // not found
        return null;
    }

    // hashmap time: O(n) space O(n)
    private int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff) && map.get(diff) != i) {
                return new int[]{i, map.get(diff)};
            }
        }


        // not found
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        int result[] = twoSum2(nums, target);
        if (result != null && result.length == 2) {
            System.out.println("[" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("no solution!");
        }

        return result;
    }

    public static void main(String []args) {
        Solution s = new Solution();
        {
            int nums[] = new int[]{2, 7, 11, 15};
            int target = 9;
            s.twoSum(nums, target);
        }

        {
            int nums[] = new int[]{3, 2, 4};
            int target = 6;
            s.twoSum(nums, target);
        }

        {
            int nums[] = new int[]{-3, -4, 4, 5, 2};
            int target = -1;
            s.twoSum(nums, target);
        }

        {
            int nums[] = new int[]{3, 2, 4};
            int target = 8;
            s.twoSum(nums, target);
        }
    }
}
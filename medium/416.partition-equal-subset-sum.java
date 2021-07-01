import java.util.*;

/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        Arrays.sort(nums);

        int targetSum = sum / 2;

        // [1,2,5]
        // [100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97]
        Map<List<Integer>, Boolean> memo = new HashMap<>();
        List<Integer> picked = new ArrayList<>();
        return dfsPickNumbers(nums, targetSum, picked);
    }

    private boolean dfsPickNumbers(int[] nums, int target, List<Integer> picked) {

        if (target == 0) {
            return true;
        }

        if (target < 0 || picked.size() == nums.length) {
            return false;
        }

        for (int i=0; i<nums.length; i++) {
            if (picked.contains(i)) {
                continue;
            }

            if (target - nums[i] < 0) {
                // prune
                break;
            }

            picked.add(i);
            if (dfsPickNumbers(nums, target - nums[i], picked)) {
                return true;
            }
            picked.remove(picked.size() - 1);

        }

        return false;
    }
}
// @lc code=end


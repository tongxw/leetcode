import java.util.Arrays;

/*
 * @lc app=leetcode id=698 lang=java
 *
 * [698] Partition to K Equal Sum Subsets
 */

// @lc code=start
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        int targetSum = sum / k;
        // System.out.println(targetSum);

        Arrays.sort(nums);
    
        // [129,17,74,57,1421,99,92,285,1276,218,1588,215,369,117,153,22]\n3
        // TLE
        return dfsCheck(nums, nums.length - 1, k, 0, targetSum, 0);
    }

    private boolean dpSolution(int[] nums, int k, int targetSum) {
        // TODO
        int size = (1 << nums.length);
        boolean[] dp = new boolean[size]; // dp[size-1] = all numbers are picked
        dp[0] = true; // i=0, empty set, no number is picked

        // all subsets
        for (int i=0; i<size; i++) {
            if (!dp[i]) {
                continue;
            }

            // get the sum of subset i
            int curSum = getSubsetSum(nums, i);
            for (int j=0; j<nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    // not picked
                    continue;
                }

                // move to next subset
                int next = i | (1 << j);
                if (dp[next]) {
                    continue;
                }

                // KEY!!
                // 对于子集i，它里面所有元素的和sum，如果 sum % target求余，余数+nums[j]不大于target
                // 说明添加nums[j]到子集i之后，新的子集是满足题意的，dp[next] = true
                int curMod = curSum % targetSum;
                if (curMod + nums[j] <= targetSum) {
                    dp[next] = true;
                } else {
                    // nums is sorted at the beginning, so
                    // curMod + nums[j+1] > curMod + nums[j] > targetSum
                    break;
                }
                
            }
        }

        return dp[size - 1];
    }

    private int getSubsetSum(int[] nums, int subSet) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            if ((subSet & i) != 0) {
                sum += nums[i];
            }
        }

        return sum;
    }

    private boolean dfsCheck(int[] nums, int begin, int group, int total, int targetSum, int picked) {
        if (group == 1) {
            // only one group left, since sum(nums) = group * targetSum, no need to check further
            return true;
        }

        if (total == targetSum) {
            // found one group
            return dfsCheck(nums, nums.length - 1, group - 1, 0, targetSum, picked);
        }

        // for (int i=0; i<nums.length; i++) {
        // try larger number first, more efficiency
        for (int i=begin; i>=0; i--) {
            if ((picked & (1 << i)) != 0) {
                continue;
            }

            if (total + nums[i] > targetSum) {
                continue;
            }

            if (dfsCheck(nums, i-1, group, total + nums[i], targetSum, picked | (1 << i))) {
                return true;
            }

            // for the same nums[i], we don't need to do further dfsCheck
            while (i-1 >=0 && nums[i-1] == nums[i]) {
                i--;
            }
        }

        //[2,2,2,2,3,4,5]\n4
        return false;

    }
}
// @lc code=end


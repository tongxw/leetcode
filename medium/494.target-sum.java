import java.util.Arrays;

/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    private int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        
        // dfsBackTracking(nums, target, 0, 0);
        // dfsBackTracking2(nums, target, 0);
        // return count;

        return dpSolution2(nums, target);
    }

    private void dfsBackTracking(int[] nums, int target,int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }

            return;
        }

        // TC O(2^n), SC O(n)
        dfsBackTracking(nums, target, index + 1, sum + nums[index]);
        dfsBackTracking(nums, target, index + 1, sum - nums[index]);
    }

    private void dfsBackTracking2(int[] nums, int target,int index) {
        if (index == nums.length) {
            if (target == 0) {
                count++;
            }

            return;
        }

        // TC O(2^n), SC O(n)
        dfsBackTracking2(nums, target - nums[index], index + 1);
        dfsBackTracking2(nums, target + nums[index], index + 1);
    }

    private int dpSolution(int[] nums, int target) {
        // 记数组的元素和为sum，添加-号的元素之和为neg，则其余添加+的元素之和为sum-neg,则
        // (sum-neg) - neg = target
        // neg = (sum - target) / 2
        // 问题转化为01背包问题：选取数组nums中任意数量的数字，其和恰好为neg。问有几种取法？


        int diff = Arrays.stream(nums).sum() - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }

        int targetSum = diff / 2; // same as 416


        int[] dp = new int[targetSum+1];
        dp[0] = 1;

        // for (int i=1; i<=nums.length; i++) {
        //     for (int j=0; j<=targetSum; j++) {
        //         dp[i][j] += dp[i-1][j];
        //         if (j - nums[i-1] >= 0) {
        //             dp[i][j] += dp[i-1][j-nums[i-1]];
        //         }
        //     }
        // }

        for (int i=1; i<=nums.length; i++) {
            for (int j=targetSum; j>=0; j--) {
                if (j - nums[i-1] >= 0) {
                    dp[j] += dp[j-nums[i-1]];
                }
            }
        }


        return dp[targetSum];
    }

    private int dpSolution2(int[] nums, int target) {
        // https://leetcode-cn.com/problems/target-sum/solution/dong-tai-gui-hua-si-kao-quan-guo-cheng-by-keepal/
        // dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j+nums[i]]
        // -sum(nums) <= j <= sum(nums)
        // return dp[nums.len - 1][target]
        int sum = Arrays.stream(nums).sum();
        if (Math.abs(target) > sum) {
            return 0;
        }

        int[][] dp = new int[nums.length][2 * sum + 1];
        // dp[i][0...sum-1]: -sum <= j < 0
        // dp[i][sum]: j == 0
        // dp[i][sum + 1... 2sum]: 0 < j <= sum

        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }

        for (int i=1; i<nums.length; i++) {
            for (int j=-sum; j<=sum; j++) {
                int j_index = j + sum;
                if (j_index - nums[i] >= 0) {
                    dp[i][j_index] += dp[i-1][j_index - nums[i]];
                }
                if (j_index + nums[i] <= 2*sum) {
                    dp[i][j_index] += dp[i-1][j_index + nums[i]];
                }
            }
        }

        // [1,0]\n1
        return dp[nums.length - 1][sum + target];
    }

}
// @lc code=end


import java.util.*;

/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    // TODO REVIEW
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        // Arrays.sort(nums);

        int targetSum = sum / 2;

        // https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/fen-ge-deng-he-zi-ji-by-leetcode-solution/
        // dp(i, j): is there a probability that nums[0...i] is subset that the sum is target j?
        //           nums 数组内前 i 个数能否构成和为 j 的子序列的可能，
        // dp(i, j): 当不选择nums[i]时，dp(i, j) = dp(i-1, j)
        //           当选择nums[i]时，如果 j == nums[i]，则dp(i, j) = true
        //                          如果 j - nums[i] > 0，则dp(i, j) = dp(i-1, j-nums[i]) 需要看上个状态
        // 所以 dp(i, j) = 不选择nums[i] or 选择nums[i]，只要两种情况之一为true，就为true

        boolean dp[][] = new boolean[nums.length][targetSum + 1];
        if (nums[0] <= targetSum) {
            dp[0][nums[0]] = true;
        }

        for (int i=1; i<nums.length; i++) {
            for (int j=1; j<=targetSum; j++) {
                if (dp[i-1][j] || j - nums[i] == 0) {
                    dp[i][j] = true;
                    continue;
                }

                if (j - nums[i] > 0) {
                    dp[i][j] = dp[i-1][j - nums[i]];
                }

                if (j == targetSum && dp[i][j]) {
                    // the last column is true, we can skip for the rest...
                    return true;
                }
            }
        }

        //[100]
        return dp[nums.length - 1][targetSum];
    }

    private boolean dpOptimized(int[] nums, int targetSum) {
        boolean[][] dp = new boolean[nums.length][targetSum + 1];
        if (nums[0] <= targetSum) {
            dp[0][nums[0]] = true;
        }

        // 为了合并j - nums[i-1] == 0时dp[i][j] = true，需要假设：
        dp[0][0] = true;

        for (int i=1; i<nums.length; i++) {
            for (int j=1; j<=targetSum; j++) {
                if (j - nums[i] >= 0) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i]];
                } else {
                    // cannot pick nums[i-1], just copy the status from last row
                    dp[i][j] = dp[i-1][j];
                }

                if (j == targetSum && dp[i][j]) {
                    return true;
                }
            }
        }

        return dp[nums.length - 1][targetSum];
    }

    private boolean dpOptimized2(int[] nums, int targetSum) {
        // 因为状态数组只跟上一行的左侧的值有关，所以可以压缩为一维数组，从右向左填表
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;
        if (nums[0] <= targetSum) {
            dp[nums[0]] = true;
        }
        for (int i=1; i<nums.length && !dp[targetSum]; i++) {
            for (int j=targetSum; j>=1; j--) {
                // 如果dp[j]已经为true，就不用更新后续状态了
                if (!dp[j] && j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }

        // [1,2,5]
        return dp[targetSum];
    }

    // TLE Time O(2^n) DFS search
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


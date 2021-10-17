import java.util.HashMap;

/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
 * [tree][dfs]
 * 这个题需要对树进行两遍dfs。dfs每个节点，对每个节点再进行dfs计算和的数量
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int total = 0;

    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // solution 2

    public int pathSum(TreeNode root, int targetSum) {
        // space O(n), time: O(n*(1+2+....+n))
        // dfs(root, targetSum);
        // return total;

        // solution 2 time O(n)
        return dfsWithPreSums(root, 0, targetSum);
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        isTargetSum(root, targetSum);
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
    }

    private void isTargetSum(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        int diff = sum - root.val;
        if (diff == 0) {
            total++;
        }

        // even if the path is found, still need to check deeper,
        // maybe the diff will be zero again in the rest of the branch.
        isTargetSum(root.left, diff);
        isTargetSum(root.right, diff);
  
        return;
    }

    // 前缀和思路
    // 这道题用到了一个概念，叫前缀和。就是到达当前元素的路径上，之前所有元素的和。
    // 在同一个路径之下（可以理解成二叉树从root节点出发，到叶子节点的某一条路径），
    // 1. 如果两个数的前缀总和是相同的，那么这些节点之间的元素总和为零。
    // 2. 进一步扩展相同的想法，如果前缀总和currSum，在节点A和节点B处相差target，则位于节点A和节点B之间的元素之和是target。

    // 抵达当前节点(即B节点)后，将前缀和累加，然后查找在前缀和上，有没有前缀和currSum-target的节点(即A节点)，
    // 存在即表示从A到B有一条路径之和满足条件的情况。结果加上满足前缀和currSum-target的节点的数量。
    // 然后递归进入左右子树。

    // 当前路径上的和
    // currSum += node.val;
    // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
    // res += prefixSumCount.getOrDefault(currSum - target, 0);
    // 更新路径上当前节点前缀和的个数
    // prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
    private int dfsWithPreSums(TreeNode root, int curSum, int target) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        curSum += root.val;
        if (curSum == target) {
            count++;
        }

        if (map.get(curSum - target) != null) {
            count += map.get(curSum - target);
        }

        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        int res = count + dfsWithPreSums(root.left, curSum, target) + dfsWithPreSums(root.right, curSum, target);
        map.put(curSum, map.getOrDefault(curSum, 0) - 1);

        return res;
    }
}
// @lc code=end


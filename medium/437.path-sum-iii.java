import java.util.HashMap;

/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
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
        return dfsWithHashmap(root, 0, targetSum);
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

    private int dfsWithHashmap(TreeNode root, int cur, int target) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        cur += root.val;
        if (cur == target) {
            count++;
        }

        if (map.get(cur - target) != null) {
            count += map.get(cur - target);
        }

        if (map.get(cur) == null) {
            map.put(cur, 1);
        } else {
            int tmp = map.get(cur);
            map.put(cur, tmp + 1);
        }

        int res = count + dfsWithHashmap(root.left, cur, target) + dfsWithHashmap(root.right, cur, target);
        int tmp = map.get(cur);
        map.put(cur, tmp - 1);

        return res;
    }
}
// @lc code=end


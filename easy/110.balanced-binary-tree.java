/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            // time O(logN), space O(height)
            return Math.abs(dfsHeight(root.left) - dfsHeight(root.right)) <= 1 &&
                    isBalanced(root.left) && isBalanced(root.right);
        }
    }

    // [1,2,2,3,null,null,3,4,null,null,4]
    // time: O(logN) ??
    private int dfsHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(dfsHeight(root.left) , dfsHeight(root.right)) + 1;
    }
}
// @lc code=end


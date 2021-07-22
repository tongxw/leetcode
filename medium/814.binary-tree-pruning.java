/*
 * @lc app=leetcode id=814 lang=java
 *
 * [814] Binary Tree Pruning
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
    public TreeNode pruneTree(TreeNode root) {
        if (isZero(root)) {
            return null;
        }

        if (isZero(root.left)) {
            root.left = null;
        } else {
            pruneTree(root.left);
        }

        if (isZero(root.right)) {
            root.right = null;
        } else {
            pruneTree(root.right);
        }

        return root;
    }


    private boolean isZero(TreeNode root) {
        if (root == null) {
            return true;
        }

        return root.val == 0 && isZero(root.left) && isZero(root.right);
    }


    // back-order traverse
    private TreeNode pruneTreeSolution(TreeNode root) {

        if (root == null)
            return null;
    
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
    
        return root.val == 0 && root.left == null && root.right == null ? null : root;
    }
}
// @lc code=end


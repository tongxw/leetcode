import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=226 lang=java
 *
 * [226] Invert Binary Tree
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
    public TreeNode invertTree(TreeNode root) {
        // recursive
        if (root == null) {
            return null;
        }

        // TreeNode left = root.left;
        // TreeNode right = root.right;
        // root.left = invertTree(right);
        // root.right = invertTree(left);

        // stack
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            if (cur.left != null) {
                stack.add(cur.left);
            }
            if (cur.right != null) {
                stack.add(cur.right);
            }
            
            TreeNode n = cur.left;
            cur.left = cur.right;
            cur.right = n;
        }

        return root;


    }
}
// @lc code=end


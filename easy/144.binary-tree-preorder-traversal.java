import java.util.ArrayList;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    public List<Integer> preorderTraversal(TreeNode root) {
        // List<Integer> ans = new ArrayList<>();
        // dfs(root, ans);
        // return ans;

        return stack(root);
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        dfs(root.left, ans);
        dfs(root.right, ans);
    }

    private List<Integer> stack(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        while (!s.isEmpty() || node != null) {
            while (node != null) {
                ans.add(node.val);

                s.push(node);
                node = node.left;
            }

            if (!s.isEmpty()) {
                node = s.pop();
                node = node.right;
            }
        }

        return ans;
    }
}
// @lc code=end


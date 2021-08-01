import java.util.ArrayList;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        dfs(root.left, ans);
        dfs(root.right, ans);
        ans.add(root.val);
    }

    private List<Integer> stack(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();

        pushLeftSubTree(root, s);
        TreeNode lastVisitNode = null;
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            if (node.right == null || node.right == lastVisitNode) {
                ans.add(node.val);
                lastVisitNode = node;
            } else {
                s.push(node);
                node = node.right;
                pushLeftSubTree(node, s);
            }
        }

        return ans;
    }

    private void pushLeftSubTree(TreeNode root, Stack<TreeNode> s) {
        while (root != null) {
            s.push(root);
            root = root.left;
        }
    }
}
// @lc code=end


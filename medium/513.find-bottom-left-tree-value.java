import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=513 lang=java
 *
 * [513] Find Bottom Left Tree Value
 * [@tree]
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
    private int dfsMaxDepth = -1;
    private int dfsRetVal = -1;

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int len = q.size();
            boolean hasNextLevel = false;
            TreeNode firstNode = null;
            for (int i=0; i<len; i++) {
                TreeNode node = q.poll();
                if (i == 0) {
                    firstNode = node;
                }
                if (node.left != null) {
                    hasNextLevel = true;
                    q.add(node.left);
                }
                if (node.right != null) {
                    hasNextLevel = true;
                    q.add(node.right);
                }
            }
            if (!hasNextLevel) {
                return firstNode.val;
            }
        }

        return -1;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        depth++;
        if (depth > dfsMaxDepth) {
            dfsMaxDepth = depth;
            dfsRetVal = root.val;
        }

        // must check left child first
        dfs(root.left, depth);
        dfs(root.right, depth);
    }


    private int bfsRightToLeft(TreeNode root) {
        if (root == null) {
            return -1;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode node = null;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i=0; i<len; i++) {
                node = q.poll();
                if (node.right != null) {
                    q.add(node.right);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
            }
        }

        return node.val;
    }

    // private void dfs(TreeNode root, Stack<Integer> stack) {
    //     if (root == null) {
    //         return;
    //     }

    //     dfs(root.right, stack);
    //     stack.push(root.val);
    //     dfs(root.left, stack);
    // }
}
// @lc code=end


import java.util.ArrayList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=1382 lang=java
 *
 * [1382] Balance a Binary Search Tree
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
    ArrayList<TreeNode> nodes = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        // time: O(N), space O(N) - array size
        dfsInorder(root);
        return dfsBuild(nodes, 0, nodes.size() - 1);
    }

    private void dfsInorder(TreeNode root) {
        if (root == null) {
            return;
        }

        dfsInorder(root.left);
        nodes.add(root);
        dfsInorder(root.right);
    }

    private TreeNode dfsBuild(ArrayList<TreeNode> nodes, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left ) / 2;
        TreeNode root = nodes.get(mid);
        root.left = dfsBuild(nodes, left, mid - 1);
        root.right = dfsBuild(nodes, mid + 1, right);

        return root;
    }
}
// @lc code=end


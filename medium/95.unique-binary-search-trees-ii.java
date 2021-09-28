import java.util.*;

/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
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
    public List<TreeNode> generateTrees(int n) {
        // BST: values in left tree < root.value < values in right tree,
        // and both left and right trees are also BST
        // so, we can consider solve the problem recursively.

        // from number 1 to n, say we pick a number i, then we just generate the unique trees
        // for [1...i-1], and  also generate trees fro [i+1...n]
        // then we can do a double iterations for left trees and right trees
        // pick a left tree and right tree, and generate a BST with root(i)

        // we do this for number from 1 to n
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }

        return buildTrees(1, n);
    }

    private List<TreeNode> buildTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();

        if (start > end) {
            // exit
            allTrees.add(null);
        } else {
            for (int i=start; i<=end; i++) {
                List<TreeNode> leftTrees = buildTrees(start, i-1);
                List<TreeNode> rightTrees = buildTrees(i+1, end);
                for (TreeNode lt: leftTrees) {
                    for (TreeNode rt: rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = lt;
                        root.right = rt;
                        allTrees.add(root);
                    }
                }
            }
        }

        return allTrees;
    }
}
// @lc code=end


import java.util.Arrays;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=889 lang=java
 *
 * [889] Construct Binary Tree from Preorder and Postorder Traversal
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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return dfsBuild1(pre, post);
    }

    private TreeNode dfsBuild1(int[] pre, int[] post) {
        if (pre == null || pre.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        if (pre.length == 1) {
            return root;
        }
        
        // left tree root: preorder[1], check its index in post order
        int leftIndex = 0;
        for (int i=0; i<post.length; i++) {
            if (post[i] == pre[1]) {
                leftIndex = i;
                break;
            }
        }

        // left tree pre[1, leftIndex+1], post[0, leftIndex]
        if (leftIndex + 1 > 0) {
            int[] lPre = Arrays.copyOfRange(pre, 1, leftIndex + 2);
            int[] lPost = Arrays.copyOfRange(post, 0, leftIndex + 1);
            root.left = dfsBuild1(lPre, lPost);
        }

        // right tree pre[leftIndex+2, end], post[leftIndex + 1, end - 1];
        if (leftIndex < pre.length - 2) {
            int[] rPre = Arrays.copyOfRange(pre, leftIndex + 2, pre.length);
            int[] rPost = Arrays.copyOfRange(post, leftIndex + 1, post.length - 1);
            root.right = dfsBuild1(rPre, rPost);
        }

        return root;
    }
}
// @lc code=end


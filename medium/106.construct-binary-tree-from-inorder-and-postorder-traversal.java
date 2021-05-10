import java.util.Arrays;

/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return dfsBuild1(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode dfsBuild1(int[] inorder, int inorderStart, int inorderEnd,
                               int[] postorder, int postOrderStart, int postOrderEnd) {
        if (inorderStart > inorderEnd || postOrderStart > postOrderEnd) {
            return null;
        }

        // the last one is the root
        TreeNode root = new TreeNode(postorder[postOrderEnd]);

        // get the index from inorder
        int rootIndex = 0;
        for (int i=inorderStart; i<=inorderEnd && i<inorder.length; i++) {
            if (postorder[postOrderEnd] == inorder[i]) {
                rootIndex = i;
                break;
            }
        }

        // right
        // if (rootIndex + 1 < inorder.length && rootIndex < postorder.length - 1) {
            // int[] rInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
            int rInOrderStart = rootIndex + 1;
            int rInOrderEnd = inorderEnd;
            // int[] rPostorder = Arrays.copyOfRange(postorder, rootIndex, postorder.length - 1);
            int rPostorderStart = rootIndex;
            int rPostorderEnd = postOrderEnd - 1;
            // root.right = dfsBuild1(rInorder, rPostorder);
            root.right = dfsBuild1(inorder, rInOrderStart, rInOrderEnd, postorder, rPostorderStart, rPostorderEnd);
        // }

        // left
        // if (rootIndex > 0) {
            // int[] lInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
            // int[] lPostorder = Arrays.copyOfRange(postorder, 0, rootIndex);
            // root.left = dfsBuild1(lInorder, lPostorder);
            root.left = dfsBuild1(inorder, 0, rootIndex - 1, postorder, 0, rootIndex - 1);
        // }

        return root;
    }
}
// @lc code=end


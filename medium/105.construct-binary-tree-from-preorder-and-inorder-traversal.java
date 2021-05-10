import java.util.Arrays;
import java.util.HashMap;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    private HashMap<Integer, Integer> inOrderMap = new HashMap<>();
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // create a hashmap so we can get the root index from inorder array quick
        for (int i=0; i<inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return dfsBuild1(preorder, inorder);
        // return dfsBuild2(preorder, 0, preorder.length-1);
    }
    private TreeNode dfsBuild1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            // complete
            return null;
        }
        
        // preorder can decide the root node
        TreeNode root = new TreeNode(preorder[0]);

        // get the location of this root in in-order array
        int rootIndex = 0;
        for (int i=0; i<inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                rootIndex = i;
                break;
            }
        }

        // left sub tree: inorder[0, indexof(preorder[0]) - 1], right sub tree: inorder[indexof(preorder[0]) + 1, ..]
        if (rootIndex > 0) {
            int[] leftInOrder = Arrays.copyOfRange(inorder, 0, rootIndex);
            int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
            root.left = dfsBuild1(leftPreOrder, leftInOrder);
        }
        if (rootIndex + 1 < inorder.length) {
            int[] rightInOrder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
            int[] rightPreOrder = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);
            root.right = dfsBuild1(rightPreOrder, rightInOrder);
        }

        return root;
    }

    private TreeNode dfsBuild2(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = dfsBuild2(preorder, left, inOrderMap.get(rootValue) - 1);
        root.right = dfsBuild2(preorder, inOrderMap.get(rootValue) + 1, right);
        return root;
    }
}
// @lc code=end


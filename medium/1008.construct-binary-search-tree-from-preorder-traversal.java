import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode id=1008 lang=java
 *
 * [1008] Construct Binary Search Tree from Preorder Traversal
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
    private HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();

    public TreeNode bstFromPreorder(int[] preorder) {
        // BST: sort preorder, the result is inorder
        // int[] inorder = Arrays.copyOf(preorder, preorder.length);
        // Arrays.sort(inorder);

        // for (int i=0; i<inorder.length; i++) {
        //     inorderMap.put(inorder[i], i);
        // }

        // return dfsBuild(preorder, 0, inorder, 0, inorder.length - 1);
        return dfsBuild2(preorder, 0, preorder.length - 1);
    }

    // time O(NlogN) space O(N)
    private TreeNode dfsBuild(int[] preorder, int preorderRootIndex,
                              int[] inorder, int inorderLeftIndex, int inorderRightIndex) {
        if (inorderLeftIndex > inorderRightIndex) {
            return null;
        }

        int val = preorder[preorderRootIndex];
        TreeNode root = new TreeNode(val);

        int inorderRootIndex = inorderMap.get(val);
        
        int leftPreOrderRootIndex = preorderRootIndex + 1;
        int leftInorderLeftIndex = inorderLeftIndex;
        int leftInorderRightIndex = inorderRootIndex - 1;
        root.left = dfsBuild(preorder, leftPreOrderRootIndex, inorder, leftInorderLeftIndex, leftInorderRightIndex);

        int lTreeLength = leftInorderRightIndex - leftInorderLeftIndex + 1;
        int rPreRootIdx = preorderRootIndex + lTreeLength + 1;
        int rInorderLeftIdx = inorderRootIndex + 1;
        int rInorderRightIdx = inorderRightIndex;
        root.right = dfsBuild(preorder, rPreRootIdx, inorder, rInorderLeftIdx, rInorderRightIdx);

        return root;
    }

    // time O(NlogN) space O(N)
    private TreeNode dfsBuild2(int[] preroder, int preroderStart, int preorderEnd) {
        if (preroderStart > preorderEnd) {
            return null;
        }

        int val = preroder[preroderStart];
        TreeNode root = new TreeNode(val);
        if (preroderStart == preorderEnd) {
            return root;
        }

        // we need to split preorder array into left tree and right tree
        // for BST, we know all the nodes in the left tree is less than root node
        // and all the nodes in the right tree is more than root node

        // int rTreeRootIndex = preroderStart + 1;
        // for (; rTreeRootIndex <= preorderEnd; rTreeRootIndex++) {
        //     if (preroder[rTreeRootIndex] > val) {
        //         break;
        //     }
        // }
        int l = preroderStart;
        int r = preorderEnd;
        while (l < r) {
            int mid = l + (r - l + 1)/2;
            if (preroder[mid] < val) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        root.left = dfsBuild2(preroder, preroderStart + 1, l);
        root.right = dfsBuild2(preroder, l+1, preorderEnd);

        return root;
    }
}
// @lc code=end


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
    private HashMap<Integer, Integer> postOrderMap = new HashMap<>();
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        for (int i=0; i<post.length; i++) {
            postOrderMap.put(post[i], i);
        }
        // return dfsBuild1(pre, post);
        return dfsBuild2(pre, 0, post, 0, post.length - 1);
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

    private TreeNode dfsBuild2(int[] pre, int preOrderRootIndex, int[] post, int postLeft, int postRight) {
        if (postLeft > postRight || preOrderRootIndex > pre.length) {
            return null;
        }

        int val = pre[preOrderRootIndex];
        TreeNode root = new TreeNode(val);
        if (preOrderRootIndex + 1 >= pre.length || postLeft == postRight) {
            return root;
        }

        int valLeft = pre[preOrderRootIndex + 1];
        int leftChildPostOrderIndex = postOrderMap.get(valLeft);
        int leftTreelength = leftChildPostOrderIndex - postLeft + 1;
        int rightPreOrderRootIndex = preOrderRootIndex + leftTreelength + 1;

        root.left = dfsBuild2(pre, preOrderRootIndex + 1, post, postLeft, leftChildPostOrderIndex);
        root.right = dfsBuild2(pre, rightPreOrderRootIndex, post, leftChildPostOrderIndex + 1, postRight - 1);

        return root;

    //     // [2,1,3]\n[3,1,2]
    }
}
// @lc code=end


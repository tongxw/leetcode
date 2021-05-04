import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
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
    public int maxDepth(TreeNode root) {
        // recur
        // if (root == null) {
        //     return 0;
        // } else if (root.left == null && root.right == null) {
        //     return 1;
        // } else  {
        //     return 1 + Math.max(maxDepth(root.left), maxDepth(root.right)); 
        // }
        
        // bfs
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        int depth = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                // for every nodes in this level, add its children
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                size--;
            }


            // now move to the next depth level
            depth += 1;
        }

        return depth;
    }
}
// @lc code=end


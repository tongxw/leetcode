import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            // return checkChildren(root.left, root.right);
            return bfs(root.left, root.right);
        }
    }

    private boolean  checkChildren(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }

        if (l == null || r == null || l.val != r.val) {
            return false;
        } else {
            return checkChildren(l.left, r.right) && checkChildren(l.right, r.left);
        }
    }

    private boolean bfs(TreeNode l, TreeNode r) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(l);
        q.offer(r);
        while (q.isEmpty()) {
            TreeNode lChild = q.poll();
            TreeNode rChild = q.poll();

            boolean isSame = true;
            if (lChild == null && rChild == null) {
                continue;
            } else if (lChild == null || rChild == null ) {
                return false;
            } else {
                if (lChild.val != rChild.val) {
                    return false;
                }
                q.offer(lChild.right);
                q.offer(rChild.left);
                q.offer(lChild.left);
                q.offer(rChild.right);
            }
        }

        return true;
    }
}
// @lc code=end


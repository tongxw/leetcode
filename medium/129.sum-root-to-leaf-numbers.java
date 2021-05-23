import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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
    public int sumNumbers(TreeNode root) {
        // return dfsSum(root, 0);
        return bfsSum(root);
    }

    private int dfsSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        
        sum *= 10; // the sum of the parent node * 10
        sum += root.val; // add value of this node
        if (root.left == null && root.right == null) {
            return sum;
        }

        return dfsSum(root.left, sum) + dfsSum(root.right, sum);
        
    }

    private int bfsSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        int sum = 0;
        q.add(root);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i=0; i<len; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    // key: update the val directly!
                    node.left.val += node.val * 10;
                    q.add(node.left);
                }
                if (node.right != null) {
                    node.right.val += node.val * 10;
                    q.add(node.right);
                }

                if (node.left == null && node.right == null) {
                    sum += node.val;
                }
            }
        }

        return sum;
    }

    private int mySolution1Wrong(TreeNode root) {
        // bfs
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        ArrayList<Integer> sums = new ArrayList<>();
        while (!q.isEmpty()) {
            int nodesCount = q.size();
            int sum = 0;
            for (int i=0; i<nodesCount; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            sums.add(sum);
        }

        int len = sums.size();
        int ans = 0;
        int tens = 1;
        int twos = 1;
        for (int i=len-1; i>=0; i--) {
            System.out.println(sums.get(i));
            ans += sums.get(i) * tens * twos;
            tens = tens * 10;
            twos = twos * 2;
        }

        return ans;
    }
}
// @lc code=end


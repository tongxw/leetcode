/*
 * @lc app=leetcode id=993 lang=java
 *
 * [993] Cousins in Binary Tree
 * [binary-tree][tree][dfs][bfs]
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
    public boolean isCousins(TreeNode root, int x, int y) {
        // we need to get the parent node and depth of a node x
        // int[] xInfo = dfs(root, null, 0, x);
        // int[] yInfo = dfs(root, null, 0, y);
    
        // int[] xInfo = bfs(root, x);
        // int[] yInfo = bfs(root, y);
        
        // return xInfo[0] != yInfo[0] && xInfo[1] == yInfo[1];

        // one search
        dfsSimple(root, null, 0, x, y);
        return parentX != parentY && depthX == depthY;
    }


    int parentX = -1;
    int depthX = -1;
    int parentY = -1;
    int depthY = -1;
    boolean foundX = false;
    boolean foundY = false;
    private void dfsSimple(TreeNode root, TreeNode parent, int depth, int x, int y) {
        if (root == null) {
            return;
        }

        if (root.val == x) {
            parentX = parent == null ? -1 : parent.val;
            depthX = depth;
            foundX = true;
        }

        if (root.val == y) {
            parentY = parent == null ? -1 : parent.val;
            depthY = depth;
            foundY = true;
        }

        if (foundX && foundY) {
            return;
        }

        dfsSimple(root.left, root, depth + 1, x, y);
        dfsSimple(root.right, root, depth + 1, x, y);
        return;
    }

    
    // we need to return: [ parent.val, depth ]
    // 这题的关键点在于想到同时返回父节点和深度，而由于没有重复数字的节点，所以返回父节点的值就可以了。
    private int[] dfs(TreeNode root, TreeNode parent, int depth, int target) {
        if (root == null) {
            // not found
            return new int[] {-1, -1};
        }
        
        if (root.val == target) {
            return new int[] { parent == null ? -1 : parent.val, depth };
        }
        
        int[] leftRes = dfs(root.left, root, depth + 1, target);
        if (leftRes[1] != -1) {
            return leftRes;
        }
        
        return dfs(root.right, root, depth + 1, target);
    }
    
    // return [parent, depth]
    private int[] bfs(TreeNode root, int target) {
        Queue<Object[]> q = new ArrayDeque<>();
        
        // [cur_node, parent_node, depth]
        int depth = 0;
        q.offer(new Object[] {root, null});
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i=0; i<n; i++) {
                Object[] info = q.poll();
                
                TreeNode cur = (TreeNode)info[0];
                TreeNode parent = (TreeNode)info[1];
                if (cur.val == target) {
                    return new int[] {parent == null ? -1 : parent.val, depth};
                }
                
                if (cur.left != null) {
                    q.offer(new Object[] {cur.left, cur});
                }
                
                if (cur.right != null) {
                    q.offer(new Object[] {cur.right, cur});
                }
                
            }
            
            depth++;
        }
        
        return new int[] {-1, -1};
        
    }
}
// @lc code=end


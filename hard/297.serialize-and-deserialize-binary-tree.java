import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuffer ret = new StringBuffer();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int len = q.size();
            boolean lastLevel = true;
            for (int i=0; i<len; i++) {
                TreeNode node = q.poll();
                ret.append(",");
                ret.append(node.val == Integer.MIN_VALUE ? "null" : String.valueOf(node.val));
                if (node.left != null) {
                    lastLevel = false;
                    q.add(node.left);
                } else if (node.val !=Integer.MIN_VALUE) {
                    q.add(new TreeNode(Integer.MIN_VALUE));
                }

                if (node.right != null) {
                    lastLevel = false;
                    q.add(node.right);
                } else if (node.val !=Integer.MIN_VALUE) {
                    q.add(new TreeNode(Integer.MIN_VALUE));
                }
            }
            if (lastLevel) {
                break;
            }
        }

        System.out.println(ret);
        return ret.substring(1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] vals = data.split(",");
        if (vals == null || vals.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        buildTree(vals, q, 1);

        //[1,2,3,null,null,4,5,null,6]
        return root;
    }
    private void buildTree(String[] vals, Queue<TreeNode> q, int beginIndex) {
        int len = q.size();
        if (beginIndex >= vals.length || len == 0) {
            return;
        }

        for (int i=0; i<len; i++) {
            TreeNode parent = q.poll();
    
            if (beginIndex >= vals.length) {
                return;
            }
            if (!vals[beginIndex].equals("null")) {
                TreeNode lChild = new TreeNode(Integer.parseInt(vals[beginIndex]));
                parent.left = lChild;
                q.add(lChild);
            }
            beginIndex++;

            if (beginIndex >= vals.length) {
                return;
            }
            if (!vals[beginIndex].equals("null")) {
                TreeNode rChild = new TreeNode(Integer.parseInt(vals[beginIndex]));
                parent.right = rChild;
                q.add(rChild);
            }
            beginIndex++;
        }

        buildTree(vals, q, beginIndex);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end


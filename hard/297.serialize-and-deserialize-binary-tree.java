import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 * [tree][design]
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

    //https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/solution/shou-hui-tu-jie-gei-chu-dfshe-bfsliang-chong-jie-f/
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String ret = dfs(root);
        System.out.println(ret);
        return ret;
    }

    private String dfs(TreeNode root) {
        if (root == null) {
            return "null";
        }

        return String.valueOf(root.val) + "," + dfs(root.left) + "," + dfs(root.right);
    }

    private String bfsSerialize(TreeNode root) {
        if (root == null) {
            return "null";
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
        if (data == null || data.equals("null")) {
            return null;
        }

        String[] list = data.split(",");

        return dfsDeserialize(list);
    }

    int pos = 0;
    private TreeNode dfsDeserialize(String[] list) {
        if (pos >= list.length || "null".equals(list[pos])) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(list[pos]));
        pos++;
        node.left = dfsDeserialize(list);
        pos++;
        node.right = dfsDeserialize(list);

        return node;
    }

    private TreeNode bfsDeserialize(String[] list) {
        TreeNode root = new TreeNode(Integer.parseInt(list[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int childPos = 1;
        while (childPos < list.length) {
            TreeNode parent = q.poll();
            String leftVal = list[childPos];
            String rightVal = list[childPos + 1];
            if (!"null".equals(leftVal)) {
                root.left = new TreeNode(Integer.parseInt(leftVal));
                q.offer(root.left);
            }
            if (!"null".equals(rightVal)) {
                root.right = new TreeNode(Integer.parseInt(rightVal));
                q.offer(root.right);
            }

            childPos += 2;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end


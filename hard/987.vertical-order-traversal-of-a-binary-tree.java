import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=987 lang=java
 *
 * [987] Vertical Order Traversal of a Binary Tree
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
    HashMap<Integer, HashMap<Integer, List<Integer>>> colToRow = new HashMap<>(); // {col: {row : [val]} }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        return myFirstSolution(root);
    }

    private List<List<Integer>> myFirstSolution(Tree root) {
        dfs(root, 0, 0);

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Integer[] cols = colToRow.keySet().toArray(new Integer[0]);
        Arrays.sort(cols);
        for (int col : cols) {
            HashMap<Integer, List<Integer>> rowToNodes = colToRow.get(col);
            ArrayList<Integer> ansVals = new ArrayList<>();
            Integer[] rows = rowToNodes.keySet().toArray(new Integer[0]);
            Arrays.sort(rows);
            for (int row : rows) {
                Integer[] valsInRow = rowToNodes.get(row).toArray(new Integer[0]);
                Arrays.sort(valsInRow);
                Collections.addAll(ansVals, valsInRow);
            }
            ans.add(ansVals);
        }

        return ans;
    }

    private void dfs(TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }

        HashMap<Integer, List<Integer>> rowToNodes = null;
        if (colToRow.containsKey(col)) {
            rowToNodes = colToRow.get(col);
        } else {
            rowToNodes = new HashMap<Integer, List<Integer>>();
            colToRow.put(col, rowToNodes);
        }

        List<Integer> nodes = null;
        if (rowToNodes.containsKey(row)) {
            nodes = rowToNodes.get(row);
        } else {
            nodes = new ArrayList<Integer>();
            rowToNodes.put(row, nodes);
        }

        nodes.add(root.val);

        // System.out.println("val: " + root.val + " (" + row + ", " + col + ")");

        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }
}
// @lc code=end


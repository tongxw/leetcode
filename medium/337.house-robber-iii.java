import java.util.HashMap;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
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
    private HashMap<TreeNode, Integer> robMap = new HashMap<>();
    private HashMap<TreeNode, Integer> notRobMap = new HashMap<>();

    public int rob(TreeNode root) {
        int[] sum = dfs(root);
        return Math.max(sum[0], sum[1]);
    }

    // dfs all the nodes of the tree, each node return two number, int[] num,
    // num[0] is the max value while rob this node,
    // num[1] is max value while not rob this value.
    // **KEY** Current node return value only depend on its children’s value.
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2]; // [0, 0]
        }

        // back-order DFS
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int[] res = new int[2];

        // rob this node
        res[0] = root.val + left[1] + right[1];

        // do not rob this node
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return res;
    }

    ////////////////////////////////////////////////////////////////////////////
    private int my1stSolution(TreeNode root) {
        return dfsRob(root, false);
    }

    private int dfsRob(TreeNode root, boolean parentRobbed) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return parentRobbed ? 0 : root.val;
        }

        if (parentRobbed) {
            if (robMap.containsKey(root)) {
                return robMap.get(root);
            }
        } else {
            if (notRobMap.containsKey(root)) {
                return notRobMap.get(root);
            }
        }


        int rob = 0;
        int notRob = 0;
        if (!parentRobbed) {
            rob += root.val + dfsRob(root.left, true) + dfsRob(root.right, true);
            notRob += dfsRob(root.left, false) + dfsRob(root.right, false);
        } else {
            notRob += dfsRob(root.left, false) + dfsRob(root.right, false);
        }

        int sum = Math.max(rob, notRob);
        if (parentRobbed) {
            robMap.put(root, sum);
        } else {
            notRobMap.put(root, sum);
        }

        return sum;
    }
}
// @lc code=end


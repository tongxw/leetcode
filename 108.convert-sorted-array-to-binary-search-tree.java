/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
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
    public TreeNode sortedArrayToBST(int[] nums) {
        // recur: time: $O(N)$, space: $O(N ^ 2)$
        // if (nums == null) {
        //     return null;
        // }

        // if (nums.length == 1) {
        //     return new TreeNode(nums[0]);
        // }

        // int[] numsL = null;
        // if (nums.length / 2 > 0) {
        //     numsL = Arrays.copyOfRange(nums, 0, nums.length / 2);
        // }

        // int[] numsR = null;
        // if (nums.length > nums.length / 2 + 1) {
        //     numsR = Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length);
        // }

        // return new TreeNode(
        //     nums[nums.length / 2], sortedArrayToBST(numsL), sortedArrayToBST(numsR));

        //dfs: time: $O(N)$, space: $O(logN)$
        return dfsBuild(nums, 0, nums.length - 1);

    }

    private TreeNode dfsBuild(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfsBuild(nums, lo, mid - 1);
        root.right = dfsBuild(nums, mid + 1, hi);

        return root;
    }
}
// @lc code=end


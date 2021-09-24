/*
 * @lc app=leetcode id=129 lang=javascript
 *
 * [129] Sum Root to Leaf Numbers
 * [@tree]
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var sumNumbers = function(root) {
    function dfs(root, total) {
      if (root == null) {
        return 0;
      }

      total = total * 10 + root.val;
      if (!root.left && !root.right) {
        return total;
      } else {
        return dfs(root.left, total) + dfs(root.right, total);
      }
    }

    return dfs(root, 0);
};
// @lc code=end


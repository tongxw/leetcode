/*
 * @lc app=leetcode id=513 lang=javascript
 *
 * [513] Find Bottom Left Tree Value
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
var findBottomLeftValue = function(root) {
  function bfs(root) {
    if (!root) {
      return -1;
    }
      let q = [root];
      let node = null;
      while (q.length !== 0) {
        node = q.shift();
        if (node.right) {
          q.push(node.right);
        }
        if (node.left) {
          q.push(node.left);
        }
      }
  
      return node === null ? -1 : node.val;
  }

  let height = -1;
  let ans = -1;
  function dfs(root, depth) {
    if (root == null) {
      return;
    }

    if (height < depth) {
      height = depth;
      ans = root.val;
    }

    dfs(root.left, depth + 1);
    dfs(root.right, depth + 1);
  }

  dfs(root, 0);
  return ans;
};
// @lc code=end


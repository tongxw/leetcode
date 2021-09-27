/*
 * @lc app=leetcode id=987 lang=javascript
 *
 * [987] Vertical Order Traversal of a Binary Tree
 * [tree]
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
 * @return {number[][]}
 */
var verticalTraversal = function(root) {
  const yMap = new Map(); // { y => { x => [val1, val2, ...] } }
  function dfs(root, x, y) {
    if (!root) {
      return null;
    }

    if (!yMap.has(y)) {
      yMap.set(y, new Map());
    }

    xMap = yMap.get(y);
    if (!xMap.has(x)) {
      xMap.set(x, []);
    }
    xMap.get(x).push(root.val);
    dfs(root.left, x + 1, y - 1);
    dfs(root.right, x + 1, y + 1);
  }
  
  dfs(root, 0, 0);
  const ySorted = [...yMap.keys()].sort((n1, n2) => {
    return n1 - n2;
  });

  const ans = [];
  for (const y of ySorted) {
    const vals = []
    xMap = yMap.get(y);
    const xSorted = [...xMap.keys()].sort((n1, n2) => {
      return n1 - n2;
    });
    for (const x of xSorted) {
      const xVals = xMap.get(x).sort((n1, n2) => {
        return n1 - n2;
      });
      vals.push(...xVals);
    }

    ans.push(vals);
  }

  // [1,2,3,4,5,6,7]
  // [1,2,3,4,6,5,7]
  return ans;
};
// @lc code=end


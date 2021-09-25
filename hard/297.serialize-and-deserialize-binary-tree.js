/*
 * @lc app=leetcode id=297 lang=javascript
 *
 * [297] Serialize and Deserialize Binary Tree
 * [tree][design]
 */
// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function(root) {
  if (!root) {
    return "";
  }

  const q = [root];
  const codec = [];
  while (q.length !== 0) {
    const node = q.shift();
    if (node) {
      codec.push(node.val);
      q.push(node.left);
      q.push(node.right);


    } else {
      codec.push('X');
    }
  }

  console.log(codec.join());
  return codec.join();
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function(data) {
  if (!data || data === 'X') {
    return null;
  }

  const codec = data.split(',');
  const root = new TreeNode(codec[0]);
  const q = [root];
  
  let childPos = 1;
  while (childPos < codec.length) {
    const parent = q.shift();
    const leftVal = codec[childPos];
    const rightVal = codec[childPos + 1];
    if (leftVal !== 'X') {
      parent.left = new TreeNode(leftVal);
      q.push(parent.left);
    }
    if (rightVal !== 'X') {
      parent.right = new TreeNode(rightVal);
      q.push(parent.right);
    }

    childPos += 2;
  }

  // [1,2,3,null,null,4,5,null,6]
  return root;
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
// @lc code=end


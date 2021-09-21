/*
 * @lc app=leetcode id=109 lang=javascript
 *
 * [109] Convert Sorted List to Binary Search Tree
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {ListNode} head
 * @return {TreeNode}
 */
var sortedListToBST = function(head) {
  return recurBuild(head, null);
};

function recurBuild(start, end) {
  if (start === end) {
    return null;
  }
  if (start.next === end) {
    return new TreeNode(start.val);
  }

  // let prev = null;
  let fast = start;
  let slow = start;
  while (fast != end && fast.next !== end) {
    // prev = slow;
    slow = slow.next;
    fast = fast.next.next;
  }

  // prev.next = null;
  node = new TreeNode(slow.val, recurBuild(start, slow), recurBuild(slow.next, end));
  // node = new TreeNode(slow.val);
  // node.left = recurBuild(list);
  // node.right = recurBuild(slow.next)
  return node;
};

// @lc code=end


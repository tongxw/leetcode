/*
 * @lc app=leetcode id=61 lang=javascript
 *
 * [61] Rotate List
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
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var rotateRight = function(head, k) {
  if (head === null || head.next === null) {
    return head;
  }

  let len = 0;
  let node = head;
  while (node !== null) {
    len++;
    node = node.next;
  }

  k = k % len;
  if (k === 0) {
    return head;
  }

  let first = head;
  let second = head;
  while (first.next !== null) {
    first = first.next;

    if (k > 0) {
      k--;
    } else {
      second = second.next;
    }
  }

  let newHead = second.next;
  second.next = null;
  first.next = head;

  // []\n0
  // [1,2]\n0
  // [1,2]\n2
  return newHead;
};
// @lc code=end


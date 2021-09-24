/*
 * @lc app=leetcode id=142 lang=javascript
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var detectCycle = function(head) {
  let fast = head;
  let slow = head;
  do {
    if (fast == null || fast.next == null) {
      return null;
    }
    fast = fast.next.next;
    slow = slow.next;
  } while(fast !== slow)

  fast = head;
  while (fast !== slow) {
    fast = fast.next;
    slow = slow.next;
  }

  return fast;
};
// @lc code=end


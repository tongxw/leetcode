/*
 * @lc app=leetcode id=24 lang=javascript
 *
 * [24] Swap Nodes in Pairs
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
 * @return {ListNode}
 */
var swapPairs = function(head) {
  if (head === null || head.next === null) {
    return head;
  }

  let dummy = new ListNode(0, head);

  let pre = dummy;
  let fast = head.next;
  let slow = head;
  while (fast !== null) {
    const next = fast.next;

    fast.next = slow;
    slow.next = next;
    pre.next = fast;

    if (next === null) {
      break;
    }
    
    pre = slow;
    slow = next;
    fast = next.next;
  }

  //[1,2,3,4]
  //[1,2,3,4,5]
  return dummy.next;
};
// @lc code=end


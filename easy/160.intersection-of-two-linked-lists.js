/*
 * @lc app=leetcode id=160 lang=javascript
 *
 * [160] Intersection of Two Linked Lists
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
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
var getIntersectionNode = function(headA, headB) {
  let setA = new Set();
  let p = headA;
  while (p !== null) {
    setA.add(p);
    p = p.next;
  }

  p = headB;
  while (p !== null) {
    if (setA.has(p)) {
      return p;
    }
    p = p.next;
  }

  return null;
  // return trick(headA, headB);
};

function trick(headA, headB) {
  let pA = headA;
  let pB = headB;

  while (pA !== pB) {
    pA = (pA === null) ? headB : pA.next;
    pB = (pB === null) ? headA : pB.next;
  }

  return pA;
}
// @lc code=end


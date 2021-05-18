/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0, head);
        ListNode pre = dummyHead;
        ListNode first = head;
        ListNode second = head.next;
        while (first != null && second != null) {
            // pre->first->second->..
            swap(pre, first, second);

            // second->first->..
            pre = first;
            first = first.next;
            if (first != null) {
                second = first.next;
            } else {
                break;
            }
        }

        return dummyHead.next;
    }

    private void swap(ListNode pre, ListNode first, ListNode second) {
        first.next = second.next;
        second.next = first;
        pre.next = second;
    }
}
// @lc code=end


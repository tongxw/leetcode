/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode node = dummyHead;
        ListNode preStartNode = null;
        int count = right - left + 1;

        while (left > 0) {
            preStartNode = node;
            node = node.next;
            left--;
        }

        ListNode lastNode = node;

        // same as 206
        ListNode prev = null;
        while (count > 0) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
            count--;
        }

        preStartNode.next = prev;
        lastNode.next = node;

        return dummyHead.next;
    }
}
// @lc code=end


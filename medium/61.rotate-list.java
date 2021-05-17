/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        // list length and last node
        ListNode last = head;
        int len = 1;
        while (last.next != null) {
            last = last.next;
            len++;
        }

        k = k % len;
        if (k == 0) {
            return head;
        }

        // get the (k + 1)th node from the last
        ListNode first = head;
        ListNode second = head;
        while (first != null) {
            first = first.next;
            if (k + 1 != 0) {
                k--;
            } else {
                second = second.next;
            }
        }

        ListNode newHead = second.next;
        second.next = null;
        last.next = head;
        return newHead;
    }

    // Time: O(k*N), limit exceeded
    private ListNode solution1(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode node = head;
        for (int i=0; i<k; i++) {
            node = rotateOnce(node);
        }

        return node;
    }

    private ListNode rotateOnce(ListNode head) {
        ListNode pre = null;
        ListNode last = head;

        while (last.next != null) {
            pre = last;
            last = last.next;
        }

        pre.next = null;
        last.next = head;
        return last;
    }
}
// @lc code=end


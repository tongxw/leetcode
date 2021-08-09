/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode next = mid.next;
        mid.next = null;

        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(next);
        return merge(l1, l2);
    }

    public ListNode getMid(ListNode head) {
        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode n1 = l1;
        ListNode n2 = l2;
        
        ListNode n = dummy;
        while (n1 != null && n2 != null) {
            if (n1.val <= n2.val) {
                n.next = n1;
                n1 = n1.next;
            } else {
                n.next = n2;
                n2 = n2.next;
            }
            n = n.next;
        }

        while (n1 != null) {
            n.next = n1;
            n1 = n1.next;
            n = n.next;
        }

        while (n2 != null) {
            n.next = n2;
            n2 = n2.next;
            n = n.next;
        }

        return dummy.next;
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }

        System.out.println("");
    }
}
// @lc code=end


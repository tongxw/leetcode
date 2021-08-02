/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode node = dummyHead;
        while (node != null) {
            node = reverseK(node, k);
        }

        //[1,2,3,4,5]\n5
        //[1,2,3,4,5]\n4
        //[1,2,3,4,5]\n3
        return dummyHead.next;
    }

    private ListNode reverseK(ListNode prevHead, int k) {
        ListNode node = prevHead.next;
        int count = k;
        while (node != null && count > 0) {
            node = node.next;
            count--;
            // System.out.println("node is: " + node.val + " count is: " + count);
        }

        if (count != 0) {
            return null;
        }


        ListNode afterNode = node;

        // if (afterNode != null) {
        //     System.out.println(afterNode.val);
        // }

        count = k;
        node = prevHead.next;
        ListNode prev = null;
        while (count > 0 && node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
            count--;
        }

        ListNode firstNode = prevHead.next;
        prevHead.next.next = afterNode;
        prevHead.next = prev;
        return firstNode;
    }
}
// @lc code=end


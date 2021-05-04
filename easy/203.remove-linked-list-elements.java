/*
 * @lc app=leetcode id=203 lang=java
 *
 * [203] Remove Linked List Elements
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
    public ListNode removeElements(ListNode head, int val) {
        // add a dummy head node, so the real head node is considered the head node as the normal node
        ListNode dummyNode = new ListNode(0, head);
        ListNode curNode = dummyNode;
        while (curNode != null && curNode.next != null) {
            ListNode nextNode = curNode.next;
            if (nextNode.val == val) {
                // skip the next node
                nextNode = nextNode.next;
                curNode.next = nextNode;
            }

            if (nextNode != null && nextNode.val != val) {
                // only update the current node if the nextNode is not the target
                curNode = nextNode;
            }
        }

        return dummyNode.next;
    }
}
// @lc code=end


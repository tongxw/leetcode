/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
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
    public ListNode deleteDuplicates(ListNode head) {
      ListNode cur = head;
      while (cur != null && cur.next != null) {
          if (cur.val == cur.next.val) {
              cur.next = cur.next.next;
              // do not move cur here
              
          } else {
              cur = cur.next;
          }
      }

      return head;
    }

    public ListNode twoPointers(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (slow.val == fast.val) {
                // do not update the list
            } else {
                // slow = slow.next;
                // slow.val = fast.val;
                slow.next = fast;
                slow = slow.next;
            }

            fast = fast.next;
        }

        slow.next = null;
        return head;
    }
}
// @lc code=end


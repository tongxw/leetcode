/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        return twoPointers(head);
    }

    private ListNode hash1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        boolean cycleFound = false;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                cycleFound = true;
                break;
            }
        }

        if (cycleFound) {
            HashSet<ListNode> set = new HashSet<>();
            while (true) {
                set.add(slow);
                slow = slow.next;
                fast = fast.next.next;
                if (fast == slow) {
                    break;
                }
            }

            slow = head;
            while (true) {
                if (set.contains(slow)) {
                    return slow;
                }
                slow = slow.next;
            }
            
        }

        return null;
    }

    private ListNode hash2(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }

        return null;
    }

    private ListNode twoPointers(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        boolean cycleFound = false;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                cycleFound = true;
                break;
            }
        }

        if (cycleFound) {
            fast = head;
            while (fast != slow) {
                slow = slow.next;
                fast = fast.next;
            }

            return fast;
            
        }

        //[1,2\n0
        return null;
    }
}
// @lc code=end


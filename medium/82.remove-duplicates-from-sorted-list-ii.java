import java.util.HashMap;

/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
        return solution2(head);
    }

    private ListNode solution2(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode pre = dummyHead;
        ListNode cur = head;

        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur != null && cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }

                // cur points to the last node of all duplicated nodes
                // link the cur.next to pre.next
                pre.next = cur.next;

                // {
                //     // if we want to keep at least one duplicated node...
                //     pre.next = cur;
                //     pre = cur;
                // }

                cur = cur.next;
            } else {
                // go check next
                pre = cur;
                cur = cur.next;
            }
        }

        // [1,1]
        return dummyHead.next;
    }


    private ListNode solution1(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);

        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                // next 2 nodes are the same
                int val = cur.next.val;
                while (cur.next != null && cur.next.val == val) {
                    // delete all the duplicated nodes
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }

    private ListNode countNodesSolution(ListNode head) {
        // just ignore the list is ordered...
        if (head == null) {
            return null;
        }
        HashMap<Integer, Integer> counterMap = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            counterMap.put(cur.val, counterMap.getOrDefault(cur.val, 0) + 1);
            cur = cur.next;
        }

        ListNode dummyHead = new ListNode(-1, head);
        cur = dummyHead;
        while (cur.next != null) {
            if (counterMap.get(cur.next.val) > 1) {
                // remove cur.next
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // ListNode h1 = l1;
        // ListNode h2 = l2;
        // ListNode prev1 = null;
        // ListNode prev2 = null;
        // int carry = 0;
        // while (l1 != null && l2 != null) {
        //     int sum = l1.val + l2.val + carry;
        //     if (sum >= 10) {
        //         carry = 1;
        //         sum = sum - 10;
        //     } else {
        //         carry = 0;
        //     }
        //     l1.val = sum;
        //     l2.val = sum;
        //     prev1 = l1;
        //     prev2 = l2;
        //     l1 = l1.next;
        //     l2 = l2.next;
        // }

        // ListNode l = null;
        // ListNode res = null;
        // ListNode prev = null;
        // if (l1 != null) {
        //     l = l1;
        //     res = h1;
        //     prev = prev1;
        // } else {
        //     l = l2;
        //     res = h2;
        //     prev = prev2;
        // }

        // while (l != null) {
        //     int sum = l.val + carry;
        //     if (sum >= 10) {
        //         carry = 1;
        //         sum = sum - 10;
        //     } else {
        //         carry = 0;
        //     }
        //     l.val = sum;
        //     prev = l;
        //     l = l.next;
        // }

        // if (prev != null && carry == 1) {
        //     prev.next = new ListNode(1, null);
        // }
        ListNode dummyHead = new ListNode(0, l1);
        ListNode cur = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                cur.next = l1;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                if (cur.next == null ) {
                    cur.next = l2;
                }
                l2 = l2.next;
            }

            carry = sum / 10;
            sum = sum % 10;
            // cur.next = new ListNode(sum);
            cur.next.val = sum;
            cur = cur.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        ListNode res = dummyHead.next;


        // [9,9]\n[9]
        // [1,2,3,4,5,6,7]\n[9,9,9,9]
        // [9,9,9,9,9,9,9]\n[9,9,9,9]
        // [9,9,9,9,9,9,9]\n[9]
        // [2,4,9]\n[5,6,4,9]
        // [5]\n[5]
        return res;
    }
}
// @lc code=end


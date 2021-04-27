/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Time: O(a+b), Space: O(a+b)
        // Stack<ListNode> a = new Stack<ListNode>();
        // Stack<ListNode> b = new Stack<ListNode>();

        // ListNode listA = headA;
        // while (listA != null) {
        //     a.push(listA);
        //     listA = listA.next;

        // }

        // ListNode listB = headB;
        // while (listB != null) {
        //     b.push(listB);
        //     listB = listB.next;

        // }

        // ListNode ret = null;
        // while(!a.empty() && !b.empty()) {
        //     listA = a.pop();
        //     listB = b.pop();
        //     if (listA == listB) {
        //         ret = listA;
        //     }
        // }

        // return ret;

        // Time: O(a+b), Space: O(a+b)
        // HashSet<ListNode> set = new HashSet<ListNode>();
        // while (headA != null) {
        //     set.add(headA);
        //     headA = headA.next;
        // }

        // while (headB != null) {
        //     if (set.contains(headB)) {
        //         return headB;
        //     }
        //     headB = headB.next;
        // }

        // return null;

        // Time O(a+b), Space: O(1)
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            if (nodeA == null) {
                nodeA = headB;
            } else {
                nodeA = nodeA.next;
            }
            if (nodeB == null) {
                nodeB = headA;
            }else {
                nodeB = nodeB.next;
            }
        }

        return nodeA;

    }
}
// @lc code=end


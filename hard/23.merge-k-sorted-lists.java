import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 * [head][devide-and-conquer][sort]
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
    public ListNode mergeKLists(ListNode[] lists) {
        // [[1,4,5],[1,3,4],[2,6]]
        // return mergeSort(lists,0, lists.length - 1);
        return heapSolution(lists);
    }

    private ListNode heapSolution(ListNode[] lists) {
        PriorityQueue<ListNode> pQ = new PriorityQueue<>((l1, l2) -> {
            return l1.val - l2.val;
        });

        for (ListNode node : lists) {
            if (node != null) {
                pQ.offer(node);
            }
        }

        ListNode head = new ListNode(-1);
        ListNode l = head;
        while (!pQ.isEmpty()) {
            ListNode node = pQ.poll();
            l.next = node;
            l = l.next;
            if (node.next != null) {
                pQ.offer(node.next);
            }
        }

        return head.next;

    }

    private ListNode mergeSort(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return lists[start];
        }

        int mid = (start + end) / 2;
        ListNode l1 = mergeSort(lists, start, mid);
        ListNode l2 = mergeSort(lists, mid+1, end);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode l = head;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l.next = l1;
                l1 = l1.next;
            } else {
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }
        while (l1 != null) {
            l.next = l1;
            l1 = l1.next;
            l = l.next;
        }
        while (l2 != null) {
            l.next = l2;
            l2 = l2.next;
            l = l.next;
        }

        return head.next;
    }
}
// @lc code=end


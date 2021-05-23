import java.util.HashMap;

/*
 * @lc app=leetcode id=1171 lang=java
 *
 * [1171] Remove Zero Sum Consecutive Nodes from Linked List
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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);

        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode p = dummyHead;
        int sum = 0;
        while (p != null) {
            sum += p.val;
            // current sum  : node
            map.put(sum, p);
            p = p.next;
        }

        p = dummyHead;
        sum = 0;
        while (p != null) {
            sum += p.val;
            if (map.containsKey(sum)) {
                // the sums at p and  map.get(sum) are the same, so the
                // sum of all nodes between them is 0.
                p.next = map.get(sum).next;
            }
            p = p.next;
        }


        // [1,2,3,-3,4]
        // [1,-1]
        return dummyHead.next;
    }
}
// @lc code=end


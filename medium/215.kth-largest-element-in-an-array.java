import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int num : nums) {
            pQ.offer(num);
            if (pQ.size() > k) {
                pQ.poll();
            }
        }

        return pQ.peek();
    }
}
// @lc code=end


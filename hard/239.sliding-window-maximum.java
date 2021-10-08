import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 * [heap]
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // monotone dequeue (similar as monotone stack) 
        // save the num index instead of num itself
        Deque<Integer> deque = new LinkedList<>();

        // head (index of max number) -> ... -> tail (index of min value)
        for (int i=0; i<k; i++) {
            // for all the nums which are smaller than the current num
            // they are useless now, just remove them
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        int[] ans = new int[nums.length - k + 1];
        int j = 0;
        ans[j++] = nums[deque.peekFirst()];
        for (int i=k; i<nums.length; i++) {
            // for all the nums (in the tail) which are smaller than the current num
            // they are useless now, just remove them
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // remove the max number (from the head) if it is not in the window
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            ans[j++] = nums[deque.peekFirst()];
        }

        return ans;

    }

    private int[] heapSolution(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((index1, index2) -> {
            return nums[index2] - nums[index1];
        });

        int[] ans = new int[nums.length - k + 1];
        int j = 0;
        for (int i=0; i<nums.length; i++) {
            if (i >= k) {
                ans[j++] = nums[pQueue.peek()];
                while (!pQueue.isEmpty() && pQueue.peek() <= i-k) {
                    pQueue.poll();
                }
            }

            pQueue.offer(i);
        }

        // [9,10,9,-7,-4,-8,2,-6]\n5
        // [1,-1]\n1
        ans[j] = nums[pQueue.peek()];
        return ans;
    }
}
// @lc code=end


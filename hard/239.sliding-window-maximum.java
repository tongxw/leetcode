import java.util.PriorityQueue;

import javax.security.auth.kerberos.KerberosTicket;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((num1, num2) -> {
            return num2 - num1;
        });
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] ans = new int[nums.length - k + 1];
        int j = 0;
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
            if (i >= k) {
                System.out.println(i);
                ans[j++] = pQueue.peek();
                int numToRemove = nums[i - k];
                if (pQueue.peek() == numToRemove) {
                    pQueue.poll();
                }
            }

            pQueue.offer(nums[i]);
        }

        // [9,10,9,-7,-4,-8,2,-6]\n5
        ans[j] = pQueue.peek();
        return ans;
    }
}
// @lc code=end


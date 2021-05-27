import java.util.HashSet;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=313 lang=java
 *
 * [313] Super Ugly Number
 */

// @lc code=start
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> pQ = new PriorityQueue<>();

        // set.add(1);
        // for (int prime : primes) {
        //     pQ.offer(prime);
        //     // set.add(prime);
        // }

        long ans = 1;
        pQ.offer(ans);
        while (n > 0) {
            ans = pQ.poll();
            while (!pQ.isEmpty() && ans == pQ.peek()) {
                pQ.poll();
            }
            for (int prime : primes) {
                pQ.offer(ans * prime);
            }

            n--;
        }

        return (int)ans;
    }
}
// @lc code=end


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=1046 lang=java
 *
 * [1046] Last Stone Weight
 */

// @lc code=start
class Solution {
    public int lastStoneWeight(int[] stones) {
        return priorityQueue(stones);
    }

    public int priorityQueue(int[] stones) {
        int len = stones.length;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(len, (p1, p2) -> p2 - p1);
        for (int stone : stones) {
            pQueue.add(stone);
        }

        while (pQueue.size() >= 2) {
            int max1 = pQueue.poll();
            int max2 = pQueue.poll();
            if (max1 != max2) {
                pQueue.offer(max1 - max2);
            } 
        }

        return pQueue.isEmpty() ? 0 : pQueue.poll();
    }

    public int basicSolution(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }

        int len = stones.length;
        Arrays.sort(stones);
        while (true) {
            stones[len - 1] -= stones[len - 2];
            stones[len - 2] = 0;
            Arrays.sort(stones);
            if (stones[len - 2] == 0) {
                break;
            }
        }
        
        // [2,7,4,1,8,1]
        // [1, 3]
        return stones[len - 1];
    }
}
// @lc code=end


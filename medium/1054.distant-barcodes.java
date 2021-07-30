import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=1054 lang=java
 *
 * [1054] Distant Barcodes
 */

// @lc code=start
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int barcode : barcodes) {
            counter.put(barcode, counter.getOrDefault(barcode, 0) + 1);
        }

        PriorityQueue<Integer> pQ = new PriorityQueue<>((e1, e2) -> {
            return counter.get(e2) - counter.get(e1);
        });

        for (int barcode : counter.keySet()) {
            pQ.offer(barcode);
        }

        int[] ans = new int[barcodes.length];
        int startIndex = 0;
        while (!pQ.isEmpty()) {
            int top = pQ.poll();
            for (int i=0; i<counter.get(top); i++) {
                ans[startIndex] = top;
                startIndex += 2; // even first, then odd
                if (startIndex >= barcodes.length) {
                    startIndex = 1;
                }
            }
        }

        return ans;
    }
}
// @lc code=end


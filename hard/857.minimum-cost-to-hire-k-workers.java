import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=857 lang=java
 *
 * [857] Minimum Cost to Hire K Workers
 */

// @lc code=start
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // key: for all the workers, their (quality) / (actual wage) should be the same
        // so, for these k people, we should find the smallest q / w
        int len = quality.length;
        // HashMap<Double, Integer> mapIndex = new HashMap<>();
        // for (int i=0; i<len; i++) {
        //     map.put()
        // }

        PriorityQueue<Eff> pQ = new PriorityQueue<>(len, (d1, d2) -> {return (int)(d1.qw - d2.qw);});
        for (int i=0 ;i<len; i++) {
            Eff eff = new Eff();
            eff.index = i;
            eff.qw = (double)quality[i]/wage[i];

            pQ.offer(eff);
        }

        double ans = 0f;
        while (k > 0) {
            int index = pQ.poll().index;
            
            k --;
        }
    }

    private class Eff {
        double qw;
        int index;
    }
}
// @lc code=end


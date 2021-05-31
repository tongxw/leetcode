import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=857 lang=java
 *
 * [857] Minimum Cost to Hire K Workers
 */

// @lc code=start
class Solution {
    //TODO review
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int len = quality.length;

        // "wage / quality" means how much this person demands for their work
        // since we need to hire at least k people for minimum cost, we need to
        // sort "wage / quality" and find the minimum k people.
        ArrayList<Worker> workers = new ArrayList<>();
        for (int i=0; i<len; i++) {
            workers.add(new Worker(quality[i], wage[i], i));
        }

        Collections.sort(workers, (worker1, worker2) -> {
            return (int)(worker1.wq - worker2.wq);
        });

        // pay the k-1 worker the minimum wage, and other workers based on quality ratio
        double cost = 0f;
        int minW = workers.get(k-1).wage;
        int minQ = workers.get(k-1).quality;
        for (int i=k-1; i>=0; i--) {
            System.out.println("worker q:" + workers.get(i).quality + " worker w: " + workers.get(i).wage);
            cost += (double)(minW * (double)(workers.get(i).quality / minQ));
        }

        return cost;
    }

    private class Worker {
        int quality;
        int wage;
        int index;
        double wq;
        Worker(int q, int w, int i) {
            this.quality = q;
            this.wage = w;
            this.index = i;
            this.wq = (double)w / q;
        }
    }
}
// @lc code=end


import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=1834 lang=java
 *
 * [1834] Single-Threaded CPU
 * [heap][sort][array]
 */

// @lc code=start
class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] tasksWithIdx = new int[n][3];
        for (int i=0; i<n; i++) {
            // { index, enqueueTime, processingTime }
            tasksWithIdx[i] = new int[]{i, tasks[i][0], tasks[i][1]};
        }

        Arrays.sort(tasksWithIdx, (t1, t2) -> t1[1] - t2[1]);
        PriorityQueue<int[]> taskQ = new PriorityQueue<>((t1 ,t2) -> {
            // sort by processing time then by index
            if (t1[2] != t2[2]) {
                return t1[2] - t2[2];
            } else {
                return t1[0] - t2[0];
            }
        });

        int[] ans = new int[n];
        int time = 1;
        int curTaskIdx = 0;
        int ansIdx = 0;
        while (ansIdx < n) {
            while (curTaskIdx < n && tasksWithIdx[curTaskIdx][1] <= time) {
                taskQ.offer(tasksWithIdx[curTaskIdx++]);
            }
            if (taskQ.isEmpty()) {
                // no task in queue, time elapse
                time = tasksWithIdx[curTaskIdx][1];
            } else {
                // processing
                int[] task = taskQ.poll();
                ans[ansIdx++] = task[0];
                time += task[2];
            }
        }

        return ans;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 */

// @lc code=start
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // create graph
        int[][] graph = new int[n][n];
        for (int[] time : times) {
            int from = time[0] - 1;
            int to = time[1] - 1;
            int weight = time[2];
            graph[from - 1][to - 1] = weight;
        }

        // dfs graph?
        int maxTime = 0;

        int[] nodeK = graph[k-1];
        for (int i=0; i<n; i++) {
            maxTime = Math.max(maxTime, getTime(i));

        }

        return maxTime;
    }

    private int getTime(int[][] graph, int from, int to) {
        
    }
}
// @lc code=end


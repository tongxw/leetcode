import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 */

// @lc code=start
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // create graph
        int infiniteCost = 6200; // times.length <= 6000 and n <= 100
        int[][] graph = new int[n+1][n+1];
        int[] dist = new int[n+1];
        for (int i=1; i<=n; i++) {
            dist[i] = infiniteCost;
            for (int j=1; j<=n; j++) {
                graph[i][j] = infiniteCost;
            }
        }
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int cost = time[2];

            graph[from][to] = cost;
            if (from == k) {
                dist[to] = cost; // set the dist to k
            }
        }

        dist[k] = 0;
        boolean[] visited = new boolean[n+1];
        visited[k] = true;

        // visit all nodes
        for (int i=1; i<=n; i++) {
            int minCost = Integer.MAX_VALUE;
            int nodeToVisit = -1;

            // find the closest node which is not visited
            for (int j=1; j<dist.length; j++) {
                if (visited[j]) {
                    continue;
                }

                if (dist[j] < minCost) {
                    minCost = dist[j];
                    // System.out.println(i + ": "  + j + ": " + minCost);
                    nodeToVisit = j;
                }
            }

            if (nodeToVisit == -1) {
                break;
            } else {
                visited[nodeToVisit] = true;
            }

            for (int m=1; m<graph[nodeToVisit].length; m++) {
                if (visited[m]) {
                    continue;
                }

                // update the shorted path from k to m
                int cost = graph[nodeToVisit][m];
                dist[m] = Math.min(dist[m],  dist[nodeToVisit] + cost);
            }
        }

        int ans = 0;
        for (int i=1; i<dist.length; i++) {
            ans = Math.max(ans, dist[i]);
        }

        return ans  == infiniteCost ? -1 : ans;
    }

    private int dijkstra(ArrayList<int[]>[] graph, int from, int to) {
        if (from == to) {
            return 0;
        }

        PriorityQueue<int[]> pQ = new PriorityQueue<>((info1, info2) -> {
            return info1[1] - info2[1];
        });

        pQ.offer(new int[]{from, 0});
        HashSet<Integer> visited = new HashSet<>();
        while (!pQ.isEmpty()) {
            int[] info = pQ.poll();
            int fromNode = info[0];
            int weight = info[1];

            if (visited.contains(fromNode)) {
                continue;
            }
            visited.add(fromNode);

            if (fromNode == to) {
                return weight;
            }

            ArrayList<int[]> node = graph[fromNode];
            for (int[] e : node) {
                if (visited.contains(e[0])) {
                    int newWeight = weight + e[1];
                    pQ.add(new int[]{e[0], newWeight});
                }
            }
        }

        
        return -1;



        // heap = [(0, start)]
        // visited = set()
        // while heap:
        //     (cost, u) = heapq.heappop(heap)
        //     if u in visited:
        //         continue
        //     visited.add(u)
        //     if u == end:
        //         return cost
        //     for v, c in graph[u]:
        //         if v in visited:
        //             continue
        //         next = cost + c
        //         heapq.heappush(heap, (next, v))
        // return -1
    }
}
// @lc code=end


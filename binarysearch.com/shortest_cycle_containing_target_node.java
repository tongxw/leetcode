import java.util.*;

// https://binarysearch.com/problems/Shortest-Cycle-Containing-Target-Node
class Solution {
    public int solve(int[][] graph, int target) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        for (int i=0; i<graph[target].length; i++) {
            q.offer(new int[]{ graph[target][i], 1 });
            visited.add(graph[target][i]);
        }

        //TC: (V+E) SC: (V), v - graph nodes, e - edges
        while(!q.isEmpty()) {
            int[] nodeAndDist = q.poll();
            int node = nodeAndDist[0];
            int dist = nodeAndDist[1];
            if (node == target) {
                return dist;
            }

            for (int i=0; i<graph[node].length; i++) {
                if (!visited.contains(graph[node][i])) {
                    q.offer(new int[]{ graph[node][i], dist + 1 });
                    visited.add(graph[node][i]);
                }
            }
        }

        return -1;
    }
}
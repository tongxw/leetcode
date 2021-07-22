import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Number of Provinces
 */

// @lc code=start
class Solution {
    private int count = 0;
    public int findCircleNum(int[][] isConnected) {
        // union find
        int[] parents = new int[isConnected.length];
        for (int i=0; i<parents.length; i++) {
            parents[i] = i;
        }

        count = isConnected.length;
        for (int i=0; i<isConnected.length; i++) {
            for (int j=i+1; j<isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j, parents);
                }
            }
        }

        return count;

    }

    private int findParent(int node, int[] parents) {
        if (parents[node] == node) {
            return node;
        } else {
            int parent = findParent(parents[node], parents);
            parents[node] = parent;
            return parent;
        }
    }

    private void union(int node1, int node2, int[] parents) {
        if (findParent(node1, parents) == findParent(node2, parents)) {
            return;
        }

        // link node1 to node2
        parents[parents[node1]] = parents[node2];
        count--;
    }

    public int findCircleNumBfs(int[][] isConnected) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[isConnected.length];
        int ans = 0;
        for (int i=0; i<isConnected.length; i++) {
            if (!visited[i]) {
                ans++;
                q.offer(i);
                visited[i] = true;
            }

            while (!q.isEmpty()) {
                int node = q.poll();
                for (int j=0; j<isConnected[node].length; j++) {
                    if (j != node && isConnected[node][j] == 1 && !visited[j]) {
                        q.offer(j);
                        visited[j] = true;
                    }
                }
            }
        }
        
        return ans;
    }

    public int findCircleNumDfs(int[][] isConnected)  {
        boolean[] visited = new boolean[isConnected.length];
        int ans = 0;
        for (int i=0; i<isConnected.length;i++) {
            if (!visited[i]) {
                ans++;
            }

            dfs(isConnected, i, visited);
        }

        return ans;
    }

    private void dfs(int[][] isConnected, int city, boolean[] visited) {
        for (int j=0; j<isConnected[0].length; j++) {
            if (isConnected[city][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, j, visited);
            }
        }
    }
}
// @lc code=end


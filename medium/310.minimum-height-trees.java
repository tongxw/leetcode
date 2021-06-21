import java.util.*;

/*
 * @lc app=leetcode id=310 lang=java
 *
 * [310] Minimum Height Trees
 */

// @lc code=start
class Solution {
    // TC: O(n), SC: O(n)
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }

        // create tree map first
        // if degree[i] == 1, then it should be the leaf node in the tree
        List<List<Integer>> treeMap = new ArrayList<>();
        int[] degree = new int[n];
        for (int i=0; i<n; i++) {
            treeMap.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            treeMap.get(edge[0]).add(edge[1]);
            treeMap.get(edge[1]).add(edge[0]);
        }

        // bfs from all "leaf" nodes
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            if (degree[i] == 1) {
                q.offer(i);
            }
        }

        // from leaf to root
        while (!q.isEmpty()) {
            ans.clear(); // reset the result, the last loop is the result
            int len = q.size();
            for (int i=0; i<len; i++) {
                int node = q.poll();
                ans.add(node);
                List<Integer> neighbors = treeMap.get(node);
                for (int neighbor : neighbors) {
                    degree[neighbor]--; // cut this level
                    if(degree[neighbor] == 1) {
                        q.offer(neighbor);
                    }
                }
            }
        }

        //1\n[]
        return ans;
    }

    // TLE
    private List<Integer> my1stSolution(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> heightToLabel = new HashMap<>();
        HashMap<Integer, Integer> distMap = new HashMap<>();
        int minHeight = n;
        for (int i=0; i<n; i++) {
            int h = bfsMaxHeight(edges, i, n, distMap);
            List<Integer> labels = null;
            if (heightToLabel.containsKey(h)) {
                labels = heightToLabel.get(h);
            } else {
                labels = new ArrayList<>();
                heightToLabel.put(h, labels);
            }
            labels.add(i);

            minHeight = Math.min(minHeight, h);
        }

        return heightToLabel.get(minHeight);
    }

    private int bfsMaxHeight(int[][] edges, int root, int n, HashMap<Integer, Integer> distMap) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(new int[]{root, 0});

        int height = 0;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            height = node[1];
            visited[node[0]] = true;
            for (int[] edge : edges) {
                if (edge[0] == node[0] && !visited[edge[1]]) {
                    q.offer(new int[]{ edge[1], height + 1 });
                }
                if (edge[1] == node[0] && !visited[edge[0]]) {
                    q.offer(new int[]{ edge[0], height + 1 });
                }
            }
        }

        return height;
    }
}
// @lc code=end


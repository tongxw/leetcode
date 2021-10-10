import java.util.*;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 *  [graph][topological-sort]
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // establish a course DAG
        List<Integer>[] dag = new List[numCourses];
        int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            // edge[1] -> edge[0]
            if (dag[edge[1]] == null) {
                dag[edge[1]] = new ArrayList<>();
            }
            dag[edge[1]].add(edge[0]);
            inDegree[edge[0]] += 1;
        }

        // top-sort bfs
        // List<Integer> ans = new ArrayList<>();
        // bfs(ans, dag, inDegree);
        // return ans.size() == numCourses ? ans.stream().mapToInt(Integer::intValue).toArray() : new int[0];

        // top sort dfs
        int[] visited = new int[numCourses]; // 0 - not visited, 1 - visiting, 2 - visited
        // boolean hasCircle = false;
        Deque<Integer> stack = new LinkedList<>();
        for (int i=0; i<numCourses; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, dag, visited, stack)) {
                    return new int[0];
                }
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    private void bfs(List<Integer> ans, List<Integer>[] dag, int[] inDegree) {
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<dag.length; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int course = q.poll();
            ans.add(course);
            if (dag[course] != null) {
                for (int next : dag[course]) {
                    inDegree[next] -= 1;
                    if (inDegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }
        }
    }

    private boolean dfs(int course, List<Integer>[] dag, int[] visited, Deque<Integer> stack) {
        visited[course] = 1;
        if (dag[course] != null) {
            for (int next : dag[course]) {
                if (visited[next] == 0) {
                    if (!dfs(next, dag, visited, stack)) {
                        return false;
                    }
                } else if (visited[next] == 1) {
                    // circle
                    return false;
                } else {
                    // no op for visited == 2
                }
            }
        }
        visited[course] = 2;
        stack.push(course);
        return true;
    }
}
// @lc code=end


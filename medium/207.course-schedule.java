import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 * [graph][topological-sort]
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // establish a course DAG
        List<Integer>[] dag = new List[numCourses];
        int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            // edge[0] -> edge[1]
            if (dag[edge[0]] == null) {
                dag[edge[0]] = new ArrayList<>();
            }
            dag[edge[0]].add(edge[1]);
            inDegree[edge[1]] += 1;
        }

        // top-sort bfs
        List<Integer> ans = new ArrayList<>();
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

        return ans.size() == numCourses;
    }

    // private boolean dfs(int num) {

    // }
}
// @lc code=end


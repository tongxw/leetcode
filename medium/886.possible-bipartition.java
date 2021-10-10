import java.util.*;

/*
 * @lc app=leetcode id=886 lang=java
 *
 * [886] Possible Bipartition
 * [graph]
 */

// @lc code=start
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] people = new List[n+1];
        for (int[] dislike : dislikes) {
            int p1 = dislike[0];
            int p2 = dislike[1];
            if (people[p1] == null) {
                people[p1] = new ArrayList<>();
            }
            if (people[p2] == null) {
                people[p2] = new ArrayList<>();
            }
            people[p1].add(p2);
            people[p2].add(p1);
        }

        // for (int i=1; i<=n; i++) {
        //     List<Integer> p = people[i];
        //     System.out.print(i + ": ");
        //     for (int person : p) {
        //         System.out.print(" " + person);
        //     }

        //     System.out.println(" ");
        // }

        int[] colors = new int[n+1];
        for (int i=1; i<=n; i++) {
            if (colors[i] != 0) {
                continue;
            }

            if (!dfs(people, i, colors, 1)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<Integer>[] people, int i, int[] colors, int color) {
        colors[i] = color;

        List<Integer> dislikePeople = people[i];
        if (dislikePeople != null) {
            for (int j : dislikePeople) {
                if (colors[j] == color) {
                    return false; 
                }

                if (colors[j] == 0 && !dfs(people, j, colors, -1 * color)) {
                    return false;
                }
            }
        }

        return true;
    }
}
// @lc code=end


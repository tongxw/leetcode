/*
 * @lc app=leetcode id=1319 lang=java
 *
 * [1319] Number of Operations to Make Network Connected
 */

// @lc code=start
class Solution {
    public int makeConnected(int n, int[][] connections) {
        int[] parents = new int[n];
        for (int i=0; i<n; i++) {
            parents[i] = i;
        }

        int extraLines = 0;
        for (int[] con : connections) {
            if (union(con[0], con[1], parents)) {
                // already connected
                extraLines++;
            }
        }

        int netGroup = 0;
        for (int i=0; i<n; i++) {
            if (parents[i] == i) {
                netGroup++;
            }
        }

        //6\n[[0,1],[0,2],[0,3],[1,2],[1,3]]
        // System.out.println(extraLines);
        // System.out.println(netGroup);
        return extraLines >= netGroup - 1 ? netGroup -1 : -1;

    }

    private int find(int com, int[] parents) {
        if (parents[com] == com) {
            return com;
        } else {
            parents[com] = find(parents[com], parents);
            return parents[com];
        }
    }

    private boolean union(int com1, int com2, int[] parents) {
        if (find(com1, parents) == find(com2, parents)) {
            return true;
        } else {
            parents[parents[com1]] = parents[com2];
            return false;
        }
    }
}
// @lc code=end


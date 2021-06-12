import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=778 lang=java
 *
 * [778] Swim in Rising Water
 */

// @lc code=start
class Solution {
    public int swimInWater(int[][] grid) {
        int minTime = 0;
        int maxTime = 0;
        for (int[] rows : grid) {
            for (int height : rows ) {
                maxTime = Math.max(maxTime, height);
            }
        }

        while (minTime <= maxTime) {
            int midTime = (minTime + maxTime) / 2;
            HashSet<Integer> visited = new HashSet<>();
            if (bfsCheck(grid, midTime, 0, 0, visited)) {
                maxTime = midTime - 1;
            } else {
                minTime = midTime + 1;
            }
        }

        return minTime;
    }

    private boolean dfsCheck(int[][] grid, int time, int i, int j, HashSet<Integer> visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }

        if (grid[i][j] > time) {
            return false;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return true;
        }

        // i <= 50, j <= 50, compress (i, j)
        if (visited.contains((i << 6) | j)) {
            return false;
        }

        visited.add((i << 6) | j);

        return dfsCheck(grid, time, i-1, j, visited) || dfsCheck(grid, time, i+1, j, visited) ||
            dfsCheck(grid, time, i, j-1, visited) ||  dfsCheck(grid, time, i, j+1, visited);

    }

    private boolean bfsCheck(int[][] grid, int time, int i, int j, HashSet<Integer> visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});
        while (!q.isEmpty()) {
            int[] ij = q.poll();
            int row = ij[0];
            int col = ij[1];

            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
                continue;
            }

            if (visited.contains((row << 6) | col)) {
                continue;
            }
            visited.add((row << 6) | col);

            if (grid[row][col] > time) {
                // dead end
                continue;
            }

            if (row == grid.length - 1 && col == grid[0].length - 1) {
                // ok
                return true;
            }

            q.offer(new int[] {row + 1, col});
            q.offer(new int[] {row - 1, col});
            q.offer(new int[] {row, col + 1});
            q.offer(new int[] {row, col - 1});
        }

        return false;
    }
}
// @lc code=end


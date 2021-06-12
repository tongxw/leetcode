import java.util.*;

/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    // dfsVisit(grid, row, col);
                    bfsVisit(grid, row, col);
                    count++;
                }
            }
        }

        return count;

    }

    // mark all the adjacent grids to 0
    private void dfsVisit(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j <0 || j >= grid[0].length) {
            return;
        }

        // '0' - sea; '1' - land but not visited yet; '2' - land and already visited
        if (grid[i][j] == '0' || grid[i][j] == '2') {
            return;
        }

        grid[i][j] = '2';

        // up
        dfsVisit(grid, i - 1, j);
        
        // down
        dfsVisit(grid, i + 1, j);

        // left
        dfsVisit(grid, i, j - 1);

        // right
        dfsVisit(grid, i, j + 1);

    }

    private void bfsVisit(char[][] grid, int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        // System.out.println("row: " + row + " col: " + col);
        q.offer(new int[]{row, col});

        while (!q.isEmpty()) {
            int[] ij = q.poll();
            int i = ij[0];
            int j = ij[1];
            // System.out.println("i: " + i + " j: " + j);
            if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
                grid[i][j] = '2';
                q.offer(new int[]{i+1, j});
                q.offer(new int[]{i-1, j});
                q.offer(new int[]{i, j+1});
                q.offer(new int[]{i, j-1});
            }
        }
    }
}
// @lc code=end


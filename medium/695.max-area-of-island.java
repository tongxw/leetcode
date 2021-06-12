import java.util.*;


/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */

// @lc code=start
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    maxArea = Math.max(maxArea, bfs(grid, row, col));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 0;
        }

        if (grid[row][col] == 0 || grid[row][col] == 2) {
            return 0;
        }

        grid[row][col] = 2;

        return 1 + dfs(grid, row + 1, col) + dfs(grid, row - 1, col) +
            dfs(grid, row, col - 1) + dfs(grid, row, col + 1);

    }

    private int bfs(int[][] grid, int row, int col) {
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[] {row, col});
        // System.out.println("start: " + row + ", " + col);
        int area = 0;
        while (!q.isEmpty()) {
            int[] rowcol = q.poll();
            int i = rowcol[0];
            int j = rowcol[1];

            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                continue;
            }

            if (grid[i][j] == 0 || grid[i][j] == 2) {
                continue;
            }

            grid[i][j] = 2;
            // System.out.print("i, j: " + i + ", " + j + " / ");
            area++;

            q.offer(new int[]{i + 1, j});
            q.offer(new int[]{i - 1, j});
            q.offer(new int[]{i, j + 1});
            q.offer(new int[]{i, j - 1});
        }

        // System.out.println("area: " + area);
        return area;
    }
}
// @lc code=end


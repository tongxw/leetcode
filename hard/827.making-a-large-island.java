import java.util.*;

/*
 * @lc app=leetcode id=827 lang=java
 *
 * [827] Making A Large Island
 */

// @lc code=start
class Solution {
    private ArrayList<Integer> islands = new ArrayList<>();
    public int largestIsland(int[][] grid) {
        int marker = 2;
        islands.add(0);
        islands.add(0);

        // mark the island with numbers, and calculate all the areas for each island
        int maxIsland = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = dfsCalculateArea(grid, i, j, marker);
                    maxIsland = Math.max(maxIsland, area);
                    islands.add(area);
                    marker++;
                }
            }
        }

        // for (int island : islands) {
        //     System.out.println(island);
        // }

        // check all the waters, if make it land...
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                // System.out.println(grid[i][j]);
                if (grid[i][j] == 0) {
                    int newIsland = 1;
                    int up = i >= 1 && grid[i-1][j] != 0 ? grid[i-1][j] : 0;
                    int down = i < grid.length - 1 && grid[i+1][j] != 0 ? grid[i+1][j] : 0;
                    int left = j >= 1 && grid[i][j-1] != 0 ? grid[i][j-1] : 0;
                    int right = j < grid[0].length - 1 && grid[i][j+1] != 0 ? grid[i][j+1] : 0;
                    // System.out.println(up + " " + down + " " + left + " " + right);
                    newIsland += islands.get(up);
                    if (down != up) {
                        newIsland += islands.get(down);
                    }
                    if (left != down && left != up) {
                        newIsland += islands.get(left);
                    }
                    if (right != up && right != down && right != left) {
                        newIsland += islands.get(right);
                    }

                    maxIsland = Math.max(maxIsland, newIsland);
                }
            }
        }

        return maxIsland;

    }

    private int dfsCalculateArea(int[][] grid, int row, int col, int marker) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 0;
        }

        if (grid[row][col] != 1) {
            return 0;
        }

        grid[row][col] = marker;

        return 1 + dfsCalculateArea(grid, row - 1, col, marker) +
            dfsCalculateArea(grid, row + 1, col, marker) +
            dfsCalculateArea(grid, row, col - 1, marker) +
            dfsCalculateArea(grid, row, col + 1, marker);
    }
}
// @lc code=end


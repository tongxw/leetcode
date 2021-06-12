/*
 * @lc app=leetcode id=463 lang=java
 *
 * [463] Island Perimeter
 */

// @lc code=start
class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int up = (i - 1 >= 0 && grid[i-1][j] == 1) ? 0 : 1;
                    int down = (i + 1 < grid.length && grid[i+1][j] == 1) ? 0 : 1;
                    int left = (j - 1 >=0 && grid[i][j-1] == 1) ? 0 : 1;
                    int right = (j + 1 < grid[0].length && grid[i][j+1] == 1) ? 0 : 1;
                    ans += up + down + left + right;

                    // dfs solution:
                    // return dfs(grid, i, j);
                }
            }
        }

        // [[0,1]]
        return ans;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 0;
        }


        if (grid[row][col] != 1) {
            return 0;
        }

        grid[row][col] = 2;

        int ans = 4 + dfs(grid, row - 1, col) + dfs(grid, row + 1, col) +
            dfs(grid, row, col - 1) + dfs(grid, row, col + 1);
        
        if (row - 1 >= 0 && grid[row-1][col] != 0) {
            ans -= 2;
        }

        if (col -1 >= 0 && grid[row][col-1] != 0) {
            ans -= 2;
        }

        return ans;
    }

    private int dfs2(int[][] grid, int row, int col) {
        // 函数因为「坐标 (r, c) 超出网格范围」返回，对应一条黄色的边
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 1;
        }
        // 函数因为「当前格子是海洋格子」返回，对应一条蓝色的边
        if (grid[row][col] == 0) {
            return 1;
        }
        // 函数因为「当前格子是已遍历的陆地格子」返回，和周长没关系
        if (grid[row][col] != 1) {
            return 0;
        }
        grid[row][col] = 2;
        return dfs2(grid, row - 1, col)
            + dfs2(grid, row + 1, col)
            + dfs2(grid, row, col - 1)
            + dfs2(grid, row, col + 1);
    }

}
// @lc code=end


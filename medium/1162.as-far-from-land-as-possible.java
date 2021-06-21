import java.util.*;

/*
 * @lc app=leetcode id=1162 lang=java
 *
 * [1162] As Far from Land as Possible
 */

// @lc code=start
// https://pic.leetcode-cn.com/a3f28eeb94837d510ad7360e756881059e65ca78489d4d9bae6973884b9870bb-%E5%8D%95%E6%BA%90BFS.gif
class Solution {
    public int maxDistance(int[][] grid) {
        // int dist = -1;
        // for (int i=0; i<grid.length; i++) {
        //     for (int j=0; j<grid[0].length; j++) {
        //         if (grid[i][j] == 0) {
        //             dist = Math.max(dist, bfsFindLand(grid, i, j));
        //         }
        //     }
        // }

        // return dist;

        return bfsFindSea(grid);
    }

    private int bfsFindLand(int[][] grid, int row, int col) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{row, col, 0}); // KEY: link the dist to the queue
        while (!q.isEmpty()) {
            int[] rowcol = q.poll();
            int i = rowcol[0];
            int j = rowcol[1];
            int dist = rowcol[2];

            if (grid[i][j] == 1) {
                return dist;
            }

            if (visited[i][j]) {
                continue;
            }
            visited[i][j] = true;

            if (i-1 >= 0) {
                q.offer(new int[]{i-1, j, dist+1});
            }
            if (i+1 < grid.length) {
                q.offer(new int[]{i+1, j, dist+1});
            }
            if (j-1 >=0) {
                q.offer(new int[]{i, j-1, dist+1});
            }
            if (j+1 < grid.length) {
                q.offer(new int[]{i, j+1, dist+1});
            }
        }

        return -1;
    }

    private int[] dx = {0,0,1,-1};
    private int[] dy = {1,-1,0,0};
    private int bfsFindSea(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        // push all the lands to the queue
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        // bfs to find the farest water from all lands
        int row = -1, col = -1;
        boolean hasSea = false;
        while (!q.isEmpty()) {
            int[] rowcol = q.poll();
            row = rowcol[0];
            col = rowcol[1];
            for (int k=0; k<4; k++) {
                int nextRow = rowcol[0] + dx[k];
                int nextCol = rowcol[1] + dy[k];
                if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid.length &&
                        grid[nextRow][nextCol] == 0) {
                    // water
                    hasSea = true;
                    grid[nextRow][nextCol] = grid[row][col] + 1; // start from 2
                    q.offer(new int[]{nextRow, nextCol});
                }
            }

        }

        return row == -1 || !hasSea ? -1 : grid[row][col] - 1; // reduce by 1
    }

}
// @lc code=end


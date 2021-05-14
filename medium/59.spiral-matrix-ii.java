/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int total = n * n;
        int count = 1;

        int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int row = 0;
        int col = 0;
        int direction = 0;
        while (count <= total) {
            res[row][col] = count++;

            // try moving to the next grid, and change the direction if out of boundary or already filled
            int nextRow = row + directions[direction][0];
            int nextCol = col + directions[direction][1];

            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || res[nextRow][nextCol] != 0) {
                direction = ++direction % 4;
            }

            // re-calculate
            nextRow = row + directions[direction][0];
            nextCol = col + directions[direction][1];

            row = nextRow;
            col = nextCol;
        }

        return res;
    }
}
// @lc code=end


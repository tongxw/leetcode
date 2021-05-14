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
        final int RIGHT = 0;
        final int DOWN = 1;
        final int LEFT = 2;
        final int UP = 3;

        int row = 0;
        int col = 0;
        int direction = RIGHT;
        while (count <= total) {
            res[row][col] = count++;

            int nextRow = row + directions[direction][0];
            if (nextRow == n) {
                direction = LEFT;
            } else if (nextRow == -1) {
                direction = RIGHT;
            }
            nextRow = row + directions[direction][0];

            int nextCol = col + directions[direction][1];
            if (nextCol == n) {
                direction = DOWN;
            } else if (nextCol == -1) {
                direction = UP;
            }
            nextCol = col + directions[direction][1];

            row = nextRow;
            col = nextCol;
        }

        return res;
    }
}
// @lc code=end


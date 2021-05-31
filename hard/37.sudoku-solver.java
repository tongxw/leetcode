import java.util.ArrayList;
import java.util.HashSet;

/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
    //TODO: time complexity?
    private boolean[][] rows = new boolean[9][9];
    private boolean[][] cols = new boolean[9][9];
    private boolean[][][] grids = new boolean[3][3][9];
    private boolean allFilled = false;
    private ArrayList<int []> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        // prepare the data
        // for i-th row, j-th col or i-th j-th grid, if number (1~9) exists, set the boolean flag to true
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    spaces.add(new int[]{i, j});
                    continue;
                }

                int num = c - '0' - 1;
                rows[i][num] = true;
                cols[j][num] = true;
                grids[i/3][j/3][num] = true;
            }
        }

        // backtracking
        backTrackingFill(board, 0);
    }

    private void backTrackingFill(char[][] board, int spaceIndex) {
        if (spaceIndex == spaces.size()) {
            allFilled = true;
            return;
        }

        int[] space = spaces.get(spaceIndex);
        int i = space[0];
        int j = space[1];

        // try to fill the space
        for (int num=0; num<9 && !allFilled; num++) {
            if (!rows[i][num] && !cols[j][num] && !grids[i/3][j/3][num]) {
                // found the valid number
                rows[i][num] = true;
                cols[j][num] = true;
                grids[i/3][j/3][num] = true;
                board[i][j] = (char)(num + 1 + '0');

                // try to fill the next space
                backTrackingFill(board, spaceIndex + 1);

                if (!allFilled) {
                    // backtracking, this number is not the answer, reset
                    rows[i][num] = false;
                    cols[j][num] = false;
                    grids[i/3][j/3][num] = false;
                }
            }
        }

    }
}
// @lc code=end


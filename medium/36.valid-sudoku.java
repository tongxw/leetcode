import java.util.HashSet;

import javax.swing.border.Border;

/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer>[] colSets = new HashSet[9];
        HashSet<Integer>[] gridSets = new HashSet[9];
        for (int i=0; i<9; i++) {
            colSets[i] = new HashSet<>();
            gridSets[i] = new HashSet<>();
        }
        int gridIndex = 0;
        for (int row=0; row<board.length; row++) {
            HashSet<Integer> rowSet = new HashSet<>();
            for (int col=0; col<board.length; col++) {
                char c = board[row][col];
                if (c == '.') {
                    continue;
                }
                int number = c - '0';

                // check rows
                if (rowSet.contains(number)) {
                    // System.out.println("check row, " + row + ", " + col + ": " + number);
                    return false;
                } else {
                    rowSet.add(number);
                }

                // check cols
                // System.out.println(row + ", " + col + ": " + number);
                if (colSets[col].contains(number)) {
                    // System.out.println("check col, " +row + ", " + col + ": " + number);
                    return false;
                } else {
                    colSets[col].add(number);
                }

                // check grids
                gridIndex = (row / 3) * 3 + (col / 3);
                if (gridSets[gridIndex].contains(number)) {
                    // System.out.println("check grid, " + row + ", " + col + ": " + number);
                    return false;
                } else {
                    gridSets[gridIndex].add(number);
                }

            }
        }

        return true;
    }
}
// @lc code=end


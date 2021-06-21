import java.util.*;
/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
    // private int count = 0;

    // TC: O(n!)
    // https://www.geeksforgeeks.org/printing-solutions-n-queen-problem/
    public int totalNQueens(int n) {

        // place queens from the left colum
        // int[][] board = new int[n][n];
        // return backTracking(board, 0);

        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> diag1Set = new HashSet<>();
        HashSet<Integer> diag2Set = new HashSet<>();

        return backTracking2(rowSet, diag1Set, diag2Set, n, 0);
    }

    // https://leetcode-cn.com/problems/n-queens-ii/solution/nhuang-hou-ii-by-leetcode-solution/
    private int backTracking2(HashSet<Integer> rowSet, HashSet<Integer> diag1Set, HashSet<Integer> diag2Set, int n, int col) {
        if (col == n) {
            // all queens are placed
            return 1;
        }

        int count = 0;
        for (int row=0; row<n; row++) {
            if (rowSet.contains(row)) {
                continue;
            }

            /* diagonals: \ */ 
            if (diag1Set.contains(row - col)) {
                continue;
            }

            /* diagonals: / */
            if (diag2Set.contains(row + col)) {
                continue;
            }

            rowSet.add(row);
            diag1Set.add(row - col);
            diag2Set.add(row + col);

            // KEY point: do not break the loop. try all the possible rows in this column
            count += backTracking2(rowSet, diag1Set, diag2Set, n, col + 1);

            rowSet.remove(row);
            diag1Set.remove(row - col);
            diag2Set.remove(row + col);
        }

        return count;
    }

    private int backTracking(int[][] board, int col) {
        if (col == board.length) {
            // all queens are placed
            return 1;
        }

        int n = board.length;
        int count = 0;
        for (int row=0; row<n; row++) {
            if (canPlaceQueen(board, row, col)) {
                board[row][col] = 1;

                // KEY point: do not break the loop. try all the possible rows in this column
                count += backTracking(board, col + 1);

                board[row][col] = 0;
            }
        }

        return count;
    }

    // search for the attacking queens from 0 to col-1 (left side only)
    private boolean canPlaceQueen(int[][] board, int row, int col) {
        int n = board.length;

        // left
        for (int i=0; i<col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // upper left
        for (int i=row, j=col; i>=0 && j>=0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
    
        // lower left
        for (int i=row, j=col; j>=0 && i<n; i++, j--)
        if (board[i][j] == 1) {
            return false;
        }

        return true;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        // go to the last row, first element
        int row = rowLen - 1;
        int col = 0;
        while(row >= 0 && col < colLen) {
            int num = matrix[row][col];
            if (num == target) {
                return true;
            } else if (num > target) {
                row -= 1; // move to previous row
            } else {
                // target is in this row, search next
                col += 1;
            }
        }

        return false;
    }

    private boolean wrongSolution(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length * matrix[0].length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midRow = mid / matrix.length;
            int midCol = mid - midRow * matrix.length;
            // System.out.println("row: " + midRow + " col: " + midCol);
            if (midRow >= matrix.length || midCol >= matrix[0].length) {
                return false;
            }

            int midVal = matrix[midRow][midCol];
            if (midVal == target) {
                return true;
            } else if (midVal > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }


        //[[1,3]\n3
        return false;
    }
}
// @lc code=end


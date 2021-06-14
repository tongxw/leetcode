/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        // TC: O(m+n)
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
}
// @lc code=end


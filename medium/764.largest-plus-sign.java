/*
 * @lc app=leetcode id=764 lang=java
 *
 * [764] Largest Plus Sign
 * [dp][array]
 */

// @lc code=start
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        // for each grid(i, j), we will count the following:
        // the length of right arm: (i, j+1) -> (i, n-1)
        // the length of left arm: (i, 0) -> (i, j-1) 
        // the length of up arm: (0, j) -> (i-1, j) 
        // the length of down arm: (i+1, j) -> (n-1, j)

        // to calculate the length, we need to check if the current grid is a mine (0)
        // since 1 <= n <= 500, we can compress (i, j) to a integer and add it to a set
        // so we don't have to do a loop mines to check every time.


        // then we get the min arm from R/L/U/D, so we get the plus sign size
        // for grid(i, j).

        // the answer should be the largest plus sign size for grid[0..n-1][0...n-1]

        // first, add mines to a set
        Set<Integer> mineSet = new HashSet<>();
        for (int[] mine: mines) {
            mineSet.add(mine[0] << 9 | mine[1]);
        }
        int[][] arms = new int[n][n];
        
        for (int i=0; i<n; i++) {
            // calculate all left arms
            int arm = 0;
            for (int j=0; j<n; j++) {
                // when we do the count, we don't need to count from the beginning
                // consider it as a 1-d array
                arm = mineSet.contains(i << 9 | j) ? 0 : arm + 1;
                arms[i][j] = arm;

                //System.out.println("row: " + i + " col: " + j + " arm: " + arm);
            }

            // calculate all right arms
            arm = 0;
            for (int j=n-1; j>=0; j--) {
                arm = mineSet.contains(i << 9 | j) ? 0 : arm + 1;
                arms[i][j] = Math.min(arms[i][j], arm);
            }
        }

        int ans = 0;
        for (int j=0; j<n; j++) {
            // calculate all up arms
            int arm = 0;
            for (int i=0; i<n; i++) {
                arm = mineSet.contains(i << 9 | j) ? 0 : arm + 1;
                arms[i][j] = Math.min(arms[i][j], arm);
            }

            // calculate all down arms
            arm = 0;
            for (int i=n-1; i>=0; i--) {
                arm = mineSet.contains(i << 9 | j) ? 0 : arm + 1;
                arms[i][j] = Math.min(arms[i][j], arm);
                ans = Math.max(ans, arms[i][j]);
            }
        }

        return ans;
    }
}
// @lc code=end


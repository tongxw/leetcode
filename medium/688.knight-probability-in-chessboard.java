import java.util.*;
/*
 * @lc app=leetcode id=688 lang=java
 *
 * [688] Knight Probability in Chessboard
 */

// @lc code=start
class Solution {
    private int[] dx = new int[] {1, -1, 1, -1, 2, -2, 2, -2};
    private int[] dy = new int[] {2, 2, -2, -2, 1, 1, -1, -1};
    public double knightProbability(int n, int k, int row, int column) {

        // 3\n1\n0\n0
        // 8\n30\n6\n4
        // HashMap<Integer, Double> memo = new HashMap<>();
        // double ans = dfsMove(n, k, row, column, memo);
        // System.out.println(memo.size());
        // return ans;

        return dpSolution(n, k, row, column);
    }

    private double dpSolution(int n, int k, int row, int col) {
        // caculate the probability of all grids in this n x n board
        double[][] dp = new double[n][n];
        dp[row][col] = 1.0;

        // move k steps TC: O(kn^2), SC: O(n^2)
        for (int step=1; step <= k; step++) {
            // probabilty this step
            double[][] dpTemp = new double[n][n];

            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    for (int m=0; m<8; m++) {
                        int newRow = i + dx[m];
                        int newCol = j + dy[m];

                        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                            dpTemp[newRow][newCol] += (dp[i][j] / 8.0); 
                        }

                    }
                }
            }

            dp = dpTemp;
        }


        double ans = 0.0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                ans += dp[i][j];
            }
        }

        return ans;
    }

    private double dfsMove(int n, int step, int row, int col, HashMap<Integer, Double> memo) {
        if (row < 0 || row >= n || col < 0 || col >= n) {
            return 0.0;
        }

        if (step == 0) {
            return 1.0;
        }

        int key = step << 13 | row << 5 | col;
        if (memo.containsKey(key)) {
            // System.out.println("hit memo!");
            return memo.get(key);
        }


        double ans =  (
            dfsMove(n, step-1, row + 1, col + 2, memo) +
            dfsMove(n, step-1, row + 1, col - 2, memo) + 
            dfsMove(n, step-1, row - 1, col + 2, memo) + 
            dfsMove(n, step-1, row - 1, col - 2, memo) + 
            dfsMove(n, step-1, row + 2, col + 1, memo) + 
            dfsMove(n, step-1, row + 2, col - 1, memo) + 
            dfsMove(n, step-1, row - 2, col + 1, memo) + 
            dfsMove(n, step-1, row - 2, col - 1, memo)
        ) / 8;
        memo.put(key, ans);

        return ans;

    }


    private double probability(int n, int row, int col) {
        int count = 0;

        count += (row + 1 >= n || col + 2 >= n) ? 0 : 1;
        count += (row + 1 >= n || col - 2 < 0) ? 0 : 1;
        count += (row + 2 >= n || col + 1 >= n) ? 0 : 1;
        count += (row + 2 >= n || col - 1 < 0 ) ? 0 : 1;
        count += (row - 1 < 0 || col + 2 >= n) ? 0 : 1;
        count += (row - 1 < 0 || col - 2 < 0 ) ? 0 : 1;
        count += (row - 2 < 0 || col + 1 >= n) ? 0 : 1;
        count += (row - 2 < 0 || col + 2 >= n) ? 0 : 1;

        return (count + 0.0) / 8;
    }
}
// @lc code=end


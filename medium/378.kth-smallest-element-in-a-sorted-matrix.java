import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pQ = new PriorityQueue<>((e1, e2) -> {
            return e1[0] - e2[0];
        });

        // int[]: {value, row, col}
        for (int i=0; i<matrix.length; i++) {
            pQ.offer(new int[] {matrix[i][0], i, 0});
        }

        for (int i=0; i<k-1; i++) {
            int[] cur = pQ.poll();
            int row = cur[1];
            int col = cur[2];
            if (col != matrix[0].length - 1) {
                pQ.offer(new int[] {matrix[row][col+1], row, col+1});
            }
        }

        return pQ.poll()[0];
    }

    // https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/you-xu-ju-zhen-zhong-di-kxiao-de-yuan-su-by-leetco/
    private int binarySearch(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(matrix, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean check(int[][] matrix, int k, int val) {
        int n = matrix.length;
        int row = n - 1;
        int col = 0;

        int total = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= val) {
                total += row + 1;
                col++;
            } else {
                row--;
            }
        }

        return total >= k;
    }
}
// @lc code=end


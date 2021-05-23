/*
 * @lc app=leetcode id=1109 lang=java
 *
 * [1109] Corporate Flight Bookings
 */

// @lc code=start
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ret = new int[n];
        // 用前缀和思路，避免从i到j的循环计算
        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1];
            int seats = booking[2];

            //从i开始，前缀和增加seats
            ret[i] += seats;
            if (j != n) {
                //从j之后，前缀和减少seats
                //注意数组index是0开始
                ret[j] -= seats;
            }
        }

        // 用前缀和计算最终结果
        int count = 0;
        for (int i=0; i<n; i++) {
            // ret[i] = ret[i] + ret[i-1]
            ret[i] += count;
            count = ret[i];
        }

        return ret;
    }

    private int[] myFirstSolution(int[][] bookings, int n) {
        int[] ret = new int[n];
        for (int[] booking : bookings) {
            for (int i=booking[0]; i<=booking[1]; i++) {
                // 注意这里i到j是连续加上同一个数，可以用前缀和优化
                ret[i-1] += booking[2];
            }

        }

        return ret;
    }
}
// @lc code=end


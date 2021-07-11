import java.util.Arrays;

/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        return greedSolution(intervals);
    }

    private int greedSolution(int[][] intervals) {
        // 为了达到局部最优，留下的区间应该是右边界越小越好，因为这样才能给后面的区间留下最大的空间。
        // 对数组按右边界排序,例如
        // [1,2],
        // [2,3],
        // [1,  3]  
        //     [3,4],
            
        // 然后从左边遍历，
        // 如果发现当前区间和上一个区间重叠了，按局部最优的贪心思路，当前区间应该删除（因为右边界更大）。
        // 如果不重叠，那么可以保留当前区间，继续检查下一区间是否可以保留。
        Arrays.sort(intervals, (val1, val2) -> {
            return val1[1] - val2[1];
        });

        int ans = 0;
        int right = intervals[0][1];
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] < right) {
                ans++;
            } else {
                right = intervals[i][1];
            }
        }

        return ans;
    }

    private int dpSolution(int[][] intervals) {
        // sort the intervals by the start number
        // then find the longest increasing subsequence
        // same as LC-300
        Arrays.sort(intervals, (val1, val2) -> {
            return val1[0] - val2[0];
        });

        // dp(i): LIS length end with intervals[i]
        // while (0 <= j < i):
        //      if start(i) >= end(j): dp(i) = max(dp(j) + 1)
        int n = intervals.length;
        int[] dp = new int[n];
        for (int i=0; i<n; i++) {
            dp[i] = 1;
        }

        int maxDp = 1;
        for (int i=0; i<n; i++) {
            for (int j=i-1; j>=0; j--) {
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);

                    // sorted array, so we count from i-1 to 0
                    // if find start(i) >= end(j), this is the max dp[i]
                    break;
                }
            }

            // System.out.println("i: " + i + " dp: " + dp[i]);
            maxDp = Math.max(maxDp, dp[i]);
        }

        return n - maxDp;
    }
}
// @lc code=end


import java.util.Arrays;

/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
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


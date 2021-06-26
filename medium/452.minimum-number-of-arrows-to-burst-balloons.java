import java.util.*;

/*
 * @lc app=leetcode id=452 lang=java
 *
 * [452] Minimum Number of Arrows to Burst Balloons
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        // same as LC-435 LC-646 LC-300
        // if we can find the longest length of the points which do not overlap
        // this is the minimum arrows we need to burst all points
        Arrays.sort(points, (p1, p2) -> {
            // [[-2147483646,-2147483645],[2147483646,2147483647]]
            if (p1[0] < p2[0]) {
                return -1;
            } else if (p1[0] > p2[0]) {
                return 1;
            } else {
                return 0;
            }
         } );
        
        // dp(i): longest length of non-overlap points, end with points[i]
        // dp(i) >= 1
        // while 0 <= j < i :
        //      if points[i][0] > points[j][1] : dp(i) = max(dp(j) + 1)
        int[] dp = new int[points.length];
        for (int i=0; i<dp.length; i++) {
            dp[i] = 1;
        }

        int ans = 1;
        for (int i=0; i<points.length; i++) {
            for (int j=i-1; j>=0; j--) {
                if (points[i][0] > points[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    break;
                }
            }
            //[[-2147483646,-2147483645],[2147483646,2147483647]]
            ans = Math.max(ans, dp[i]);
        }

        // points
        return ans;
    }
}
// @lc code=end


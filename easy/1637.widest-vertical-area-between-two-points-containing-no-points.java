/*
 * @lc app=leetcode id=1637 lang=java
 *
 * [1637] Widest Vertical Area Between Two Points Containing No Points
 */

// @lc code=start
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (x, y) -> x[0] - y[0]);
        int result = 0;
        for (int i=0; i<points.length - 1; i++) {
            if (result < points[i+1][0] - points[i][0]) {
                result = points[i+1][0] - points[i][0];
            }
        }
        
        return result;
    }
}
// @lc code=end


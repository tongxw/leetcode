/*
 * @lc app=leetcode id=1423 lang=java
 *
 * [1423] Maximum Points You Can Obtain from Cards
 */

// @lc code=start
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        long sum = 0;
        for (int point : cardPoints) {
            sum += point;
        }

        int len = cardPoints.length - k;

        // KEY!!!
        if (len == 0) {
            return (int)sum;
        }

        int r = 0;
        long winSum = 0;
        while (r < len - 1) {
            winSum += cardPoints[r];
            r++;
        }

        long minSum = Integer.MAX_VALUE;
        for (int l=0; r < cardPoints.length; r++, l++) {
            winSum += cardPoints[r];
            minSum = Math.min(minSum, winSum);
            winSum -= cardPoints[l];
        }

        //[9,7,7,9,7,7,9]\n7
        return (int)(sum - minSum);
    }
}
// @lc code=end


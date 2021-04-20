// https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/

import java.util.*;

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (x, y) -> x[0] - y[0]);
        int result = 0;
        for (int i=0; i<points.length - 1; i++) {
            if (result < points[i+1][0]- points[i][0]) {
                result = points[i+1][0]- points[i][0];
            }
        }
        
        return result;
        
    }

    public static void main(String []args) {
        Solution s = new Solution();
        {
            int points[][] = new int[][]{{3,1},{9,0},{1,0},{1,4},{5,3},{8,8}};
            int result = s.maxWidthOfVerticalArea(points);
            System.out.println(result);
        }
    }
}
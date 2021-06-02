import java.util.HashMap;

/*
 * @lc app=leetcode id=447 lang=java
 *
 * [447] Number of Boomerangs
 */

// @lc code=start
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> counterMap = new HashMap<>();
        int total = 0;

        for (int i=0; i<points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            counterMap.clear();
            for (int j=0; j<points.length; j++) {
                int x1 = points[j][0];
                int y1 = points[j][1];

                int distance = (x-x1)*(x-x1) + (y-y1)*(y-y1);
                counterMap.put(distance, counterMap.getOrDefault(distance, 0) + 1);
            }

            for (int counter : counterMap.values()) {
                total += counter * (counter - 1);
            }
        }

        // [[0,0],[1,0],[-1,0],[0,1],[0,-1]]
        // [[1,1],[2,2],[3,3],[4,4],[5,5],[6,6],[7,7],[8,8]]
        return total;
    }
}
// @lc code=end


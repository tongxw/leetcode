import java.util.*;

/*
 * @lc app=leetcode id=657 lang=java
 *
 * [657] Robot Return to Origin
 */

// @lc code=start
class Solution {
    public boolean judgeCircle(String moves) {
        Map<Character, int[]> directions = new HashMap<>() {
            {
                put('U', new int[]{0, -1});
                put('D', new int[]{0, 1});
                put('L', new int[]{-1, 0});
                put('R', new int[]{1, 0});
            }
        };

        int x = 0;
        int y = 0;
        for (char c : moves.toCharArray()) {
            int[] dir = directions.get(c);
            x += dir[0];
            y += dir[1];
        }

        return x == 0 && y == 0;
    }
}
// @lc code=end


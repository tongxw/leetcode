import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode id=575 lang=java
 *
 * [575] Distribute Candies
 */

// @lc code=start
class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int type: candyType) {
            set.add(type);
        }

        return Math.min(candyType.length / 2, set.size());
    }
}
// @lc code=end


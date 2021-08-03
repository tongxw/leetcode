import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=645 lang=java
 *
 * [645] Set Mismatch
 */

// @lc code=start
class Solution {
    public int[] findErrorNums(int[] nums) {
        int sum = (1 + nums.length) * nums.length / 2;
        boolean[] seen = new boolean[nums.length + 1];
        int repeatNum = 0;
        for (int num : nums) {
            sum -= num;
            if (seen[num]) {
                repeatNum = num;
            }
            seen[num] = true;
        }


        int missingNum = sum + repeatNum;
        return new int[] {repeatNum, missingNum};
    }
}
// @lc code=end


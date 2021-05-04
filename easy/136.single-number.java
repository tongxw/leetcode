import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // for (int num: nums) {
        //     if (map.containsKey(num)) {
        //         map.put(num, 2);
        //     } else {
        //         map.put(num, 1);
        //     }

        // }

        // for (int num : map.keySet()) {
        //     if (map.get(num) == 1) {
        //         return num;
        //     }
        // }

        // return 0;


        // exclusive or
        // 1. num ^ num = 0;
        // 2. num ^ 0 = num;
        int res = 0;
        for(int num: nums)
        {
            res ^= num;
        }
        return res;
    }
}
// @lc code=end


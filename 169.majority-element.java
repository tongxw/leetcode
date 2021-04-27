import java.util.HashMap;
/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // for (int num: nums) {
        //     int i = 0;
        //     if (map.containsKey(num)) {
        //         i = map.get(num);
        //     }
        //     if (++i > nums.length / 2) {
        //         return num;
        //     }
        //     map.put(num, i);
        // }

        // return 0;

        // count votes (majority must appear more than n/2)
        int count = 1;
        int majority = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == majority) {
                // more votes
                count++;
            } else if (count > 0) {
                // less votes
                count--;
            } else {
                // this one is lost, update the majority to new one
                majority = nums[i];
                count = 1;
            }
        }

        return majority;
    }
}
// @lc code=end


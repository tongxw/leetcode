import java.util.HashMap;

/*
 * @lc app=leetcode id=992 lang=java
 *
 * [992] Subarrays with K Different Integers
 */

// @lc code=start
class Solution {
    private HashMap<Integer, Integer> map = new HashMap<>();

    public int subarraysWithKDistinct(int[] nums, int k) {
        return bruteForce(int[] nums, int k);
    }

    private int bruteForce(int nums, int k) {
        int total = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j=i; j<nums.length; j++) {
                // count how many different numbers in [i...j]
                if (map.size() > k) {
                    break;
                }
                total++;
            }
        }
    }

}
// @lc code=end


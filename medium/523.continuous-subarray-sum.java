import java.util.HashMap;

/*
 * @lc app=leetcode id=523 lang=java
 *
 * [523] Continuous Subarray Sum
 */

// @lc code=start
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return false;
        }
        long[] preSums = new long[len];
        preSums[0] = nums[0];
        for (int i=1; i<len; i++) {
            preSums[i] = nums[i] + preSums[i-1];
        }

        // sum(i, j) = preSum(j) - preSum(i-1)
        // sum(i, j) = n * k => sum(i, j) % k = 0 => (preSum(j) - preSum(i-1)) % k = 0
        // => preSum(j) % k = preSum(i-1) % k
        // they must have the same remainder when divided by k
        HashMap<Integer, Integer> map = new HashMap<>(); // { preSum[i] % k : i}
        map.put(0, -1);
        for (int i=0; i<len; i++) {
            int mod = Math.floorMod(preSums[i], k);
            if (map.containsKey(mod)) {
                // System.out.println("found mod: " + mod + " i: " + i);
                if (i - map.get(mod) > 1) {
                    return true;
                }
            } else {
                // System.out.println("put mod: " + mod + " i: " + i);
                map.put(mod, i);
            }
        }

        // [5,0,0,0]\n3
        // [0]\n1
        // [2,4,6,7]\n6
        // [23,2,4,6,6]\n7
        // [1,0]\n2
        return false;

    }
}
// @lc code=end


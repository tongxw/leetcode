import java.util.HashMap;

/*
 * @lc app=leetcode id=1590 lang=java
 *
 * [1590] Make Sum Divisible by P
 */

// @lc code=start
class Solution {
    public int minSubarray(int[] nums, int p) {
        int len = nums.length;
        long[] preSums = new long[len];
        preSums[0] = nums[0];
        for (int i=1; i<len; i++) {
            preSums[i] = nums[i] + preSums[i-1];
        }

        // modular arithmetic
        // the total sum of the array and the total sum of the sub array must have the same remainder when divided by p
        long sum = preSums[len-1];
        int mod = Math.floorMod(sum, p);
        // System.out.println("sum: " + sum);
        // System.out.println("mod: " + mod);

        // sum(i, j) % k == mod
        // sum(i, j) = preSum[j] - preSum[i] => (preSum[j] - preSum[i]) % k == mod => preSum[j] - preSum[i] == n * k + mod =>
        // preSum[i] = preSum[j] - mod - n * k => preSum[i] % k = (preSum[j] - mod) % k
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = nums.length;
        for (int i=0; i<len; i++) {
            int preSumMod = Math.floorMod(preSums[i], p);
            map.put(preSumMod, i);
            int target = Math.floorMod(preSums[i] - mod, p);
            if (map.containsKey(target)) {
                ans = Math.min(ans, i - map.get(target));
            }
        }

        // [1000000000,1000000000,1000000000]\n3
        return ans == nums.length ? -1 : ans;

        // return myFirstSolution(nums, p);
    }

    // Time Limit Exceeded
    private int myFirstSolution(int[] nums, int k) {
        long[] preSums = new long[nums.length];
        HashMap<Long, Integer> map = new HashMap<>();
        preSums[0] = nums[0];
        map.put(preSums[0], 0);
        // System.out.print(preSums[0]);
        for (int i=1; i<nums.length; i++) {
            preSums[i] = preSums[i-1] + nums[i];
            // System.out.print(" " + preSums[i]);
            map.put(preSums[i], i);
        }
        // System.out.println("");

        long sum = preSums[nums.length - 1];
        if (sum % k == 0) {
            return 0;
        }

        long div = sum / k;
        // System.out.println("sum: " + sum);
        // System.out.println("div: " + div);

        int ans = nums.length;
        map.put((long)0, -1);
        while (div != 0) {
            long remainder = sum - (k * div); // preSum[r] - preSum[l-1] == mod => preSum[l-1] == preSum[r] - mod
            for (int i=0; i<preSums.length; i++) {
                long target = preSums[i] - remainder;
                if (target >= 0 && map.containsKey(target)) {
                    // System.out.println("target: " + target);
                    ans = Math.min(ans, i - map.get(target));
                }

                if (ans == 1) {
                    return ans;
                }
            }

            div--;
        }

        //[17,6,22,31,25,4,18,32,18,26,2,31,26,8,12,2]\n142
        //[8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2]\n148
        return ans == nums.length ? -1 : ans;
    }
}
// @lc code=end


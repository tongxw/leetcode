import java.util.*;

// https://binarysearch.com/problems/Delete-Sublist-to-Make-Sum-Divisible-By-K

class Solution {
    public int solve(int[] nums, int k) {
        int[] preSums = new int[nums.length];
        preSums[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            preSums[i] = preSums[i-1] + nums[i];
        }

        // modular arithmetic
        // the total sum of the array and the total sum of the sub array must have the same remainder when divided by k
        int sum = preSums[nums.length - 1];
        int mod = sum % k;

        // sum(i, j) % k == mod
        // sum(i, j) = preSum[j] - preSum[i] => (preSum[j] - preSum[i]) % k == mod => preSum[j] - preSum[i] == n * k + mod =>
        // preSum[i] = preSum[j] - mod - n * k => preSum[i] % k = (preSum[j] - mod) % k
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int ans = nums.length;
        for (int i=0; i<preSums.length; i++) {
            int preSumMod = preSums[i] % k;
            map.put(preSumMod, i);

            int target = (preSums[i] - mod) % k;
            if (map.containsKey(target)) {
                ans = Math.min(ans, i - map.get(target));
            }
        }

        return ans == nums.length ? -1 : ans;
    }

    private int myFirstSolution(int[] nums, int k) {
        int[] preSums = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        preSums[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            preSums[i] = preSums[i-1] + nums[i];
            map.put(preSums[i], i);
        }

        int sum = preSums[nums.length - 1];
        if (sum % k == 0) {
            return 0;
        }

        int div = sum / k;

        int ans = nums.length;
        while (div != 0) {
            int mod = sum - (k * div); // preSum[r] - preSum[l-1] == mod => preSum[l-1] == preSum[r] - mod
            for (int i=0; i<preSums.length; i++) {
                int target = preSums[i] - mod;
                if (target == 0) {
                    ans = Math.min(ans, i + 1);
                } else if (target > 0 && map.containsKey(target)) {
                    ans = Math.min(ans, i - map.get(target));
                }
            }

            div--;
        }

        return ans == nums.length ? -1 : ans;
    }
}
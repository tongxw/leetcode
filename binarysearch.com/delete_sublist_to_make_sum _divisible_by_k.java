import java.util.*;

// https://binarysearch.com/problems/Delete-Sublist-to-Make-Sum-Divisible-By-K
import java.util.*;

class Solution {
    public int solve(int[] nums, int k) {
        int[] preSums = new int[nums.length];
        preSums[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            preSums[i] = preSums[i-1] + nums[i];
        }

        int sum = preSums[nums.length - 1];
        if (sum % k == 0) {
            return 0;
        }

        int div = sum / k;

        int ans = nums.length;
        while (div != 0) {
            int mod = sum - (k * div); // preSum[r] - preSum[l-1] == mod => preSum[l-1] == preSum[r] - mod
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i=0; i<preSums.length; i++) {
                int target = preSums[i] - mod;
                if (target == 0) {
                    ans = Math.min(ans, i + 1);
                } else if (target > 0 && map.containsKey(target)) {
                    ans = Math.min(ans, i - map.get(target));
                }

                map.put(preSums[i], i);
            }

            div--;
        }

        return ans == nums.length ? -1 : ans;
    }
}
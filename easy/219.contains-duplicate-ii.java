import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=219 lang=java
 *
 * [219] Contains Duplicate II
 */

// @lc code=start
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // time O(N * k)
        // for (int i=0; i<nums.length; i++) {
        //   // search backward, from i+1 to i+k;
        //   for (int j=i+1; j<nums.length && j<=i+k; j++) {
        //     if (nums[i] == nums[j]) {
        //       return true;
        //     }
        //   }

        //   // search forward,  from i-1 to i-k;
        //   for (int j=i-1; j>=0 && j>=i-k; j--) {
        //     if (nums[i] == nums[j]) {
        //       return true;
        //     }
        //   }

        // }

        // two sum (similar) time O(n) space O(n)
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
          if (map.get(nums[i]) != null) {
            int j = map.get(nums[i]);
            if (i - j <= k) {
              return true;
            }
          }

          map.put(nums[i], i);
        }

        // not found
        return false;
    }
}
// @lc code=end


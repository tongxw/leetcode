import java.util.HashSet;

/*
 * @lc app=leetcode id=260 lang=java
 *
 * [260] Single Number III
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int mask = 1;
        while ((mask & xor) == 0) {
            mask <<= 1;
        }

        int[] ans = new int[2];
        for (int num : nums) {
            if ((num & mask) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }

        return ans;
    }

    private int[] hashmapSolution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        int[] ans = new int[2];
        int i = 0;
        for (int num : set) {
            if (i == 2) {
                break;
            }
            ans[i++] = num;
        }

        return ans;
    }
}
// @lc code=end


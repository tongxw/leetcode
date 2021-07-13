/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        // a ^ 0 = a
        // a ^ a = 0
        int xor = 0;
        for (int i=0; i<nums.length ;i++) {
            xor ^= nums[i];
            xor ^= i;
        }

        return xor ^ nums.length;
    }

    private int mathSolution(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }

}
// @lc code=end


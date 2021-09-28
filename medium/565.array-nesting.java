/*
 * @lc app=leetcode id=565 lang=java
 *
 * [565] Array Nesting
 * [array]
 */

// @lc code=start
class Solution {
    public int arrayNesting(int[] nums) {
        // since the numbers in the array are different to each other, which means, each number will be
        // added in one "loop" only once.
        // so, when we check the loop length from nums[0], we can mark the numbers which are visited,
        // and we don't need to check the loop length start from the visited numbers.

        // for the visited flag, we can do a in-place modification, if nums[i] is visited, set it to -1
        int ans = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == -1) {
                // visited
                continue;
            }

            int counter = 0;
            int nextIdx = nums[i];
            nums[i] = -1;
            while (nextIdx != -1) {
                // System.out.print(nextIdx + " ");
                counter++;
                int temp = nums[nextIdx];
                nums[nextIdx] = -1;
                nextIdx = temp;
            }

            System.out.println("");

            ans = Math.max(ans, counter);
        }

        return ans;
    }
}
// @lc code=end


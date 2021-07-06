/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        // 每次在上次能跳到的范围（end）内选择一个能跳的最远的位置（也就是能跳到furthest位置的点）作为下次的起跳点 ！
        int ans = 0;
        int furthest = 0;
        int end = 0;
        // 重要！！
        // 在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，
        // 我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。
        // 如果访问最后一个元素，在边界正好为最后一个位置的情况下，
        // 我们会增加一次「不必要的跳跃次数」，因此我们不必访问最后一个元素。
        // 看题！题目要求跳到最后一个元素，不是跳出去
        for (int i=0; i<nums.length - 1; i++) {
            // this step, find the furthest dist between [i...end]
            furthest = Math.max(furthest, i + nums[i]);
            if (i == end) {
                // now reach the end. jump next and update the next end
                ans++;
                end = furthest;
            }
        }

        return ans;
    }
}
// @lc code=end


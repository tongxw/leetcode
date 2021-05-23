/*
 * @lc app=leetcode id=303 lang=java
 *
 * [303] Range Sum Query - Immutable
 */

// @lc code=start
class NumArray {
    private int[] preSums;
    public NumArray(int[] nums) {
        this.preSums = new int[nums.length + 1];
        for (int i=1; i<nums.length + 1; i++) {
            preSums[i] = nums[i-1] + preSums[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return preSums[right + 1] - preSums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
// @lc code=end


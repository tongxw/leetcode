/*
 * @lc app=leetcode id=35 lang=javascript
 *
 * [35] Search Insert Position
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function(nums, target) {
  let l = 0;
  let r = nums.length - 1;
  while (l <= r) {
    // let mid = l + Math.floor((r - l) / 2);
    let mid = l + ((r - l) >> 1);
    if (nums[mid] === target) {
      return mid;
    } else if (nums[mid] < target) {
      l = mid + 1;
    } else {
      r = mid - 1;
    }
  }

  return l;
};
// @lc code=end


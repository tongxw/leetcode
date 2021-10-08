/*
 * @lc app=leetcode id=26 lang=javascript
 *
 * [26] Remove Duplicates from Sorted Array
 * [2pointers]
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
  // ordered array and in-place modification => 2 pointers
  let write = 0;
  let read = 0;
  while(read < nums.length) {
    if (nums[write] === nums[read]) {
      read++;
    } else {
      nums[++write] = nums[read];
      read++;
    }
  }

  return write + 1;
};
// @lc code=end


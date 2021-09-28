/*
 * @lc app=leetcode id=1 lang=javascript
 *
 * [1] Two Sum
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    const map = new Map();
    let i = 0;
    let j = -1;
    for (i=0; i<nums.length; i++) {
      if (map.has(target - nums[i])) {
        j = map.get(target - nums[i]);
        break;
      } else {
        map.set(nums[i], i);
      }
    }

    return j == -1 ? [] : [i, j];
};
// @lc code=end


/*
 * @lc app=leetcode id=347 lang=javascript
 *
 * [347] Top K Frequent Elements
 * [array][hashmap][heap]
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function(nums, k) {
    const counters = new Map();
    nums.forEach(num => {
      if (counters.has(num)) {
        counters.set(num, counters.get(num) + 1);
      } else {
        counters.set(num, 1);
      }
    });

    return [...counters.keys()].sort((n1, n2) => {
      return counters.get(n2) - counters.get(n1);
    }).slice(0, k);
};
// @lc code=end


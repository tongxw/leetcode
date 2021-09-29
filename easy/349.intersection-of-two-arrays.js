/*
 * @lc app=leetcode id=349 lang=javascript
 *
 * [349] Intersection of Two Arrays
 * [hashmap]
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersection = function(nums1, nums2) {
  let set = new Set();
  nums1.forEach(num => {
    set.add(num);
  })

  let ans = new Set();
  nums2.forEach(num => {
    if (set.has(num)) {
      ans.add(num);
    }
  });

  return [...ans];
}
// @lc code=end


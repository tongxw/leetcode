/*
 * @lc app=leetcode id=350 lang=javascript
 *
 * [350] Intersection of Two Arrays II
 * [array][hashmap][2pointers]
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersect = function(nums1, nums2) {
  return twoPointers(nums1, nums2);

  function hashmap(nums1, nums2) {
    // in addition to #349, we also need to count the same numbers
    // so we need to use hashmap, not hashset

    let counters = new Map();
    nums1.forEach(num => {
      const counter = counters.get(num) || 0;
      counters.set(num, counter + 1);
    });

    const ans = [];
    nums2.forEach(num => {
      const counter = counters.get(num) || 0;
      if (counter > 0) {
        ans.push(num);
        counters.set(num, counter - 1);
      }
    });
  }

  function twoPointers(nums1, nums2) {
    // we can also sort two arrays and cross-check two arrays
    // to cross-check two arrays, this should remind you of two pointers solution
    // point i to nums1[0] and j to nums2[0]
    // if nums1[i] === nums2[j], i++ and j++, record nums1[i]
    // if nums1[i] > nums2[j], j++; else i++
    nums1.sort((a, b) => a - b);
    nums2.sort((a, b) => a - b);
    let i=0, j=0;
    let ans = [];
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] < nums2[j]) {
        i++;
      } else if (nums1[i] > nums2[j]) {
        j++;
      } else {
        ans.push(nums1[i]);
        i++;
        j++;
      }
    }

    return ans;
  }
};
// @lc code=end


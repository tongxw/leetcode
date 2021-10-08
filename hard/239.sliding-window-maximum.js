/*
 * @lc app=leetcode id=239 lang=javascript
 *
 * [239] Sliding Window Maximum
 * [heap]
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var maxSlidingWindow = function(nums, k) {
  let ans = [];
  const pQ = new MaxPriorityQueue({ priority: (idx) => nums[idx] });
  let l = 0;
  for (let r=0; r<nums.length; r++) {
    pQ.enqueue(r);
    if (r >= k-1) {
      // console.log(pQ.toArray());
      while (pQ.front().element < l) {
        // not in window
        pQ.dequeue();
      }
      ans.push(nums[pQ.front().element]);
      l++;
    }
  }

  // [9,10,9,-7,-4,-8,2,-6]\n5
  // [1,-1]\n1
  return ans;
};
// @lc code=end


/*
 * @lc app=leetcode id=698 lang=javascript
 *
 * [698] Partition to K Equal Sum Subsets
 * [backtracking]
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var canPartitionKSubsets = function(nums, k) {
  const sum = nums.reduce((prev, cur) => prev + cur, 0);
  if (sum % k !== 0) {
    return false;
  }

  const targetSum = sum / k;
  // console.log(targetSum);

  // we have to sort first
  nums.sort((a, b) => a - b);
  // console.log(nums);

  function dfs(start, curSum, pickedFlag, path) {
    // check if curSum is the group sum
    if (curSum === targetSum) {
      // console.log('found : ' + pickedFlag.toString(2));      
      if (pickedFlag === (1 << nums.length) - 1) {
        return true;
      } else {
        // pass, check next group
        return dfs(0, 0, pickedFlag);
      }
    }
    
    // else if (curSum > targetSum) {
    //   return false;
    // }

    for (let i=start; i<nums.length; i++) {
      if ((pickedFlag & (1 << i)) !== 0) {
        // picked
        continue;
      }

      if (curSum + nums[i] > targetSum) {
        continue;
      }

      // console.log('pick: ' + i + ' picked: ' + pickedFlag.toString(2));

      if (dfs(i + 1, curSum + nums[i], pickedFlag | (1 << i))) {
        return true;
      }
    }

    // console.log('false : ' + pickedFlag.toString(2));
    return false;
  }

  return dfs(0, 0, 0);
};
// @lc code=end


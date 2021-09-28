/*
 * @lc app=leetcode id=978 lang=javascript
 *
 * [978] Longest Turbulent Subarray
 * [dp]
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {number}
 */
var maxTurbulenceSize = function(arr) {
  // in a common case, we should use dp(i) for the LTS of arr[0...i]
  // but in this case, only one array dp(i) is not enough
  // we need to also remember if the previous pair of numbers go up or they go down.
  // so we will have two dp arrays:
  // up(i): LTS of arr[0...i] and arr[i] > arr[i-1], the last two numbers go up
  // down(i): LTS of arr[0...i] and arr[i] < arr[i-1], the last two numbers go down
  // initialize up(i) = down(i) = 1, since at least the len is 1
  // if arr[i] > arr[i-1]: up(i) = down(i-1) + 1
  // if arr[i] < arr[i-1]: down(i) = up(i-1) + 1

  // finally, return max(up, down)
  if (arr.length < 2) {
    return arr.length;
  }

  let ans = 1;
  const up = new Array(arr.length).fill(1);
  const down = new Array(arr.length).fill(1);
  for (let i=1; i<arr.length; i++) {
    if (arr[i] > arr[i-1]) {
      up[i] = down[i-1] + 1;
    } else if (arr[i] < arr[i-1]) {
      down[i] = up[i-1] + 1;
    }

    ans = Math.max(ans, Math.max(up[i], down[i]));
  }

  return ans;
};
// @lc code=end

// wrong solution:
// we can define dp[i] as the longest turbulent sub array arr[0...i]
// so we have the following
// dp(0) = 1;
// dp(1) = 2 if arr[1] != arr[0] else 1
// for dp(i), we need to check three elements, arr[i], arr[i-1], arr[i-2]
// case1. if arr[i-1] > arr[i-2]
//          if arr[i] < a[i-1] => dp(i-1) + 1
//          else => dp(i-1) 

// case2. if arr[i-1] < arr[i-2]
//          if arr[i] > arr[i-1] => dp(i-1) + 1
//          else => dp(i-1)

// case3. if arr[i-1] = arr[i-2]: dp(i) = max(dp(i-1), 1) = dp(i-1);

// return max(dp)
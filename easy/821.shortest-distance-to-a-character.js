/*
 * @lc app=leetcode id=821 lang=javascript
 *
 * [821] Shortest Distance to a Character
 */

// @lc code=start
/**
 * @param {string} s
 * @param {character} c
 * @return {number[]}
 */
var shortestToChar = function(s, c) {
  let ans = new Array(s.length);
  let count = s.length;
  for (let i=0; i<s.length; i++) {
    count = s[i] === c ? 0 : count + 1;
    ans[i] = count;
  }

  count = s.length;
  for (let i=s.length-1; i>=0; i--) {
    count = s[i] === c ? 0 : count + 1;
    ans[i] = Math.min(ans[i], count);
  }

  //"abaa"\n"b"
  return ans;
};
// @lc code=end


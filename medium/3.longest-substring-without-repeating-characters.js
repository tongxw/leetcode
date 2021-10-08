/*
 * @lc app=leetcode id=3 lang=javascript
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    const window = new Set();
    let l = 0;
    let ans = 0;
    for (let r = 0; r<s.length; r++) {
      //console.log('r: ' + s[r]);
      while(window.has(s[r]) && l < r) {
        //console.log('remove l: ' + s[l])
        window.delete(s[l]);
        l++;
      }
      window.add(s[r]);
      ans = Math.max(ans, r - l + 1);
    }

    return ans;
};
// @lc code=end


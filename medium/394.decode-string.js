/*
 * @lc app=leetcode id=394 lang=javascript
 *
 * [394] Decode String
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var decodeString = function(s) {
  let stack = [];

  let num = 0;
  for (let i=0; i<s.length; i++) {
    if (s[i] >= '0' && s[i] <= '9') {
      num = num * 10 + (s[i] - '0');
    } else if (s[i] === '[') {
      stack.push(num);
      num = 0;
      stack.push(s[i]);
    } else if (s[i] === ']') {
      let str = '';
      while (stack[stack.length - 1] !== '[') {
        str = stack.pop() + str;
      }
      stack.pop(); // '['

      let temp = '';
      let repeat = stack.pop();
      while (repeat > 0) {
        temp += str;
        repeat--;
      }
      stack.push(temp);
    } else {
      // chars
      stack.push(s[i]);
    }
  }

  let ans = '';
  while (stack.length !== 0) {
    ans = stack.pop() + ans;
  }

  return ans;
};
// @lc code=end


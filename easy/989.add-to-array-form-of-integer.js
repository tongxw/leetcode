/*
 * @lc app=leetcode id=989 lang=javascript
 *
 * [989] Add to Array-Form of Integer
 */

// @lc code=start
/**
 * @param {number[]} num
 * @param {number} k
 * @return {number[]}
 */
var addToArrayForm = function(num, k) {
    i = num.length - 1;
    carry = 0;
    ans = [];
    while(i >= 0 || k != 0) {
      sum = carry;
      if (i >= 0) {
        sum += num[i];
        i--;
      }
      if (k != 0) {
        sum += k % 10;
        k = Math.floor(k / 10);
      }

      carry = Math.floor(sum / 10);
      ans.unshift(sum % 10);
    }

    if (carry > 0) {
      ans.unshift(carry);
    }

    return ans;
};
// @lc code=end


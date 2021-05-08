/*
 * @lc app=leetcode id=1332 lang=java
 *
 * [1332] Remove Palindromic Subsequences
 */

// @lc code=start
class Solution {
    public int removePalindromeSub(String s) {
        // key info:
        // Note that a subsequence does not necessarily need to be contiguous.
        // so...
        // if s is palindrome, return 1
        // otherwise, return 2 (remove all 'a' then all 'b')
        if ("".equals(s)) {
            return 0;
        }  else if (s.equals(new StringBuffer(s).reverse().toString())) {
            return 1;
        } else {
            return 2;
        }
    }
}
// @lc code=end


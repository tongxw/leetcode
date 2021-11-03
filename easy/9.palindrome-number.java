/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // Revert half of the number
        // For example, if the input is 1221, if we can revert the last part of the number "1221" from "21" to "12",
        // and compare it with the first half of the number "12", since 12 is the same as 12, we know that
        // the number is a palindrome.
        
        // how do we know that we've reached the half of the number?
        // Since we divided the number by 10, and multiplied the reversed number by 10, when the original number is
        // less than the reversed number, it means we've processed half of the number digits.
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        
        // x = 1221 => x = 12 and rev = 12
        // x = 12321 => x = 12 and rev = 123
        return x == rev || x == rev / 10;
        
        
        // String strX = String.valueOf(x);
        // StringBuilder sb = new StringBuilder(strX);
        // return strX.equals(sb.reverse().toString());
    }
}
// @lc code=end


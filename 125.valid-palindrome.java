import jdk.javadoc.internal.doclets.formats.html.resources.standard_ja;

/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        int left=0;
        int right=s.length() - 1;
        while (left<right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }

            // while (!Character.isLetterOrDigit((s.charAt(left))) && left<right) { left++; }
            // while (!Character.isLetterOrDigit((s.charAt(right))) && left<right) { right--; }
            // if (left >= right) {
            //     return true;
            // }

            String str1 = String.valueOf(s.charAt(left));
            String str2 = String.valueOf(s.charAt(right));
            if (!str1.equalsIgnoreCase(str2)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=504 lang=java
 *
 * [504] Base 7
 */

// @lc code=start
class Solution {
    public String convertToBase7(int num) {
        // note: num can be negative
        boolean isNegative = false;
        if (num == 0) {
            return "0";
        } else if (num < 0) {
            isNegative = true;
            num = -num;
        }
        StringBuffer res = new StringBuffer();
        while (num >= 7) {
            res.insert(0, num % 7);
            num = num / 7;
        }

        res.insert(0, num);
        if (isNegative) {
            res.insert(0, "-");
        }
        return res.toString();
    }
}
// @lc code=end


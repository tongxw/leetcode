/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        int srcLen = haystack.length();
        int tgtLen = needle.length();
        if (tgtLen == 0) {
            return 0;
        } else if (srcLen == 0 || tgtLen > srcLen) {
            return -1;
        }
        // if (needle.isEmpty()) {
        //     return 0;
        // } else if (haystack.isEmpty()) {
        //     return -1;
        // }

        // if (needle.length() > haystack.length()) {
        //     return -1;
        // }

        for (int i=0; i<srcLen - tgtLen + 1 ; i++) {
            for (int j=0; j<tgtLen; j++) {
                if (haystack.charAt(j+i) != needle.charAt(j)) {
                    // no match
                    break;
                }
                if (j == tgtLen - 1) {
                    // match
                    return i;
                }
            }
            // if (haystack.charAt(i) == needle.charAt(0)) {
            //     boolean match = true;
            //     for (int j=i+1, k=1; j<haystack.length() && k<needle.length(); j++, k++) {
            //         if (haystack.charAt(j) != needle.charAt(k)) {
            //             match = false;
            //             break;
            //         }
            //     }
                
            //     if (match) {
            //         return i;
            //     }
            // }
        }

        return -1;
    }
}
// @lc code=end


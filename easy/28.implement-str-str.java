/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        // KMP
        // https://leetcode-cn.com/problems/implement-strstr/solution/shua-chuan-lc-shuang-bai-po-su-jie-fa-km-tb86/
        if (needle.length() == 0)
            return 0;

        int i = 0, j = 0;

        int[] next = getNext(needle);

        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j > 0) {
                    j = next[j - 1];
                } else {
                    i++;
                }
            }

            if (j == needle.length()) {
                return i - j;
            }
        }

        return -1;
    }

    private int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        int j = 0;
        for (int i=1; i<pattern.length(); i++) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                next[i] = ++j;
            } else {
                while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                    j = next[j - 1];
                }

                if (pattern.charAt(i) == pattern.charAt(j)) {
                    next[i] = ++j;
                }
            }
        }

        return next;
    }

    private int slidingWindow(String haystack, String needle) {
        // sliding window
        int srcLen = haystack.length();
        int tgtLen = needle.length();
        if (tgtLen == 0) {
            return 0;
        } else if (srcLen == 0 || tgtLen > srcLen) {
            return -1;
        }

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
        }

        return -1;
    }
}
// @lc code=end


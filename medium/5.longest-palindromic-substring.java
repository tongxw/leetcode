
/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        // dp(i, j): if s.subString(i, j+1) is palindrome
        // dp(i, j) = dp(i+1, j-1) and s[i] == s[j]
        // dp(i, i) is true
        // dp(i, i+1) = (s[i] == s[i+1])
        // get the max len from all dp(i, j) == true
        int len = s.length();
        if (len < 2) {
            return s;
        }

        boolean[][] dp = new boolean[len][len];
        for (int i=0; i<len; i++) {
            dp[i][i] = true;
        }

        // TC: O(n2), SC: O(n2)
        // check all the possible sub strings from length = 2
        int begin = 0;
        int maxLen = 1;
        for (int subStringLen = 2; subStringLen <= len; subStringLen++) {
            for (int i=0; i<len; i++) {
                // subStringLen = j - i + 1
                int j = subStringLen + i - 1;
                if (j >= len) {
                    break;
                }

                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    // s[i] == s[j]
                    if (subStringLen < 4) {
                        dp[i][j] = true; // at most 3 chars
                    } else {
                        dp[i][j] = dp[i+1][j-1]; // && s[i] == s[j]
                    }
                }

                if (dp[i][j] && subStringLen > maxLen) {
                    maxLen = subStringLen;
                    begin = i;
                }
            }
        }

        // ""bb""
        return s.substring(begin, begin + maxLen);

    }

    // private boolean dp(String s, int start, int end) {
    //     if (start == end) {
    //         return true;
    //     }


    //     return dp(s, start + 1, end - 1) && s.charAt(start) == s.charAt(end);
    // }

    private String slidingWindowWrongSolution(String s) {
        int l=0;
        int maxLen = 0;
        int ansL = 0;
        int ansR = 0;
        for (int r=0; r<s.length(); r++) {
            while(!isPalindrome(s.substring(l, r+1))) {
                // System.out.println(s.substring(l, r+1));
                l++;
            }

            // System.out.println(s.substring(l, r+1));
            if (maxLen < r - l + 1) {
                maxLen = r - l + 1;
                ansL = l;
                ansR = r;
            }
        }

        return s.substring(ansL, ansR+1);
    }


    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end


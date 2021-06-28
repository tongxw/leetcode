import java.util.*;

/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 */

// @lc code=start
class Solution {
    // LCS 583 712 1143
    // https://leetcode-cn.com/problems/longest-common-subsequence/solution/fu-xue-ming-zhu-er-wei-dong-tai-gui-hua-r5ez6/
    public int longestCommonSubsequence(String text1, String text2) {
        /*
         * 动态规划也是有套路的：单个数组或者字符串要用动态规划时，可以把动态规划 dp[i] 定义为 nums[0:i] 中想要求的结果；
         * 当两个数组或者字符串要用动态规划时，可以把动态规划定义成两维的 dp[i][j]，
         * 其含义是在 A[0:i] 与 B[0:j] 之间匹配得到的想要的结果。
         */

        // dp(i, j): length of LCS from text1[0..i-1] and text2[0...j-1]
        // dp(i, j) = 0 if i==0 or j==0, one string is empty

        // if text[i-1] == text[j-1] : dp(i, j) = dp(i-1, j-1) + 1
        // else: dp(i, j) = max(dp(i-1, j), dp(i, j-1))
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];

        for(int i=1; i<len1+1; i++) {
            for (int j=1; j<len2+1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }

        return dp[len1][len2];
    }

    private int my1stWrongSolution(String text1, String text2) {
        // dp(i) => length of LCS end with text1[i]
        // dp(0) => 1 if text1[0] in text2, otherwise 0
        // dp(1) => dp(0) + 1 if index of text1[1] in text2 > index of text1[0], otherwise dp(0)
        // dp(i) => dp(i-1) + 1 if index of text1[1] in text2 > index of text1[0], otherwise dp(0)
        // return dp(len(text1) - 1)
        int len = text1.length();
        int[] dp = new int[len];
        int[] indexes = new int[len];
        HashMap<Character, Integer> lastIndexMap = new HashMap<>();


        for (int i=0; i<len; i++) {
            // if there is duplicated char
            char c = text1.charAt(i);
            int lastIndex = lastIndexMap.getOrDefault(c, -1);
            indexes[i] = text2.indexOf(text1.charAt(i), lastIndex + 1);
            lastIndexMap.put(c, indexes[i]);

            if (i == 0) {
                if (indexes[i] != -1) {
                    dp[i] = 1;
                    // lastIndex = indexes[i];
                }
            } else {
                if (indexes[i] == -1) {
                    indexes[i] = indexes[i-1];
                }
                dp[i] = dp[i-1];
                for (int j=0; j<i; j++) {
                    if (indexes[i] > indexes[j]) {
                        System.out.println("char: " + c);
                        System.out.println("i: " + i + " index: " + indexes[i] + " j: " + j + " index: " + indexes[j] + " dp + 1: " + (dp[j] + 1));
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            System.out.println("i: " + i + " dp: " + dp[i]);
        }

        // ""bacde"\n"zcea""
        // ""bacde"\n"zbea""
        // ""cpqrs"\n"lqrypy""
        // ""abcba"\n"abcbcba""
        // ""pmjghexybyrgzczy"\n"hafcdqbgncrcbihkd""
        return dp[len-1];
    }
}
// @lc code=end


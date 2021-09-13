import java.util.Arrays;

/*
 * @lc app=leetcode id=522 lang=java
 *
 * [522] Longest Uncommon Subsequence II
 */

// @lc code=start
class Solution {
    public int findLUSlength(String[] strs) {
        // THIS IS NOT LCS!!!
        // key thinking: for each str in strs, if the str is not a subsequence of
        // any other str, this is a candidate of the answer.
        // get the max length of all candidates

        // sort the strs by length, so we don't have to check all strs
        Arrays.sort(strs, (str1, str2) -> {
            return str2.length() - str1.length();
        });

        int ans = -1;

        // cross check
        for (int i=0, j; i<strs.length; i++) {
            for (j=0; j<strs.length; j++) {
                if (i == j) {
                    continue;
                }

                if (isSubseq(strs[i], strs[j])) {
                    break;
                }
            }

            if (j == strs.length) {
                ans = strs[i].length();
                break;
            }
        }

        return ans;
    }

    private boolean isSubseq(String source, String toCompare) {
        int i=0, j=0;
        while (i < source.length() && j < toCompare.length()) {
            if (source.charAt(i) == toCompare.charAt(j)) {
                i++;
            }

            j++;
        }

        return i == source.length();
    }
}
// @lc code=end


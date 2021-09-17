/*
 * @lc app=leetcode id=521 lang=java
 *
 * [521] Longest Uncommon Subsequence I
 */

// @lc code=start
class Solution {
    public int findLUSlength(String a, String b) {
        int ans = -1;

        if (!isSubseq(a, b)) {
            ans = Math.max(ans, a.length());
        }

        if (!isSubseq(b, a)) {
            ans = Math.max(ans, b.length());
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


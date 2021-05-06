import java.util.Arrays;

/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // must sort, and give the less greedy child smaller cookie
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        for (int i=0, j=0; i<g.length && j<s.length;) {
            if (g[i] <= s[j]) {
                // content, next one
                count++;
                i++;
                j++;
            } else {
                // try next cookie
                j++;
            }
        }

        return count;
    }
}
// @lc code=end


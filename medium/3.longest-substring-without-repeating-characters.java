import java.util.HashSet;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();

        int l=0,r=0;
        int ans = 0;
        while (r<chars.length) {
            if (!set.contains(chars[r])) {
                set.add(chars[r]);
                ans = Math.max(ans, r-l+1);
                r++;
            } else {
                // c is a duplicated char, move the left side
                while (set.contains(chars[r])) {
                    set.remove(chars[l]);
                    l++;
                }
            }
        }

        return ans;

    }
}
// @lc code=end


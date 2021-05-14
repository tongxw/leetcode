import java.sql.Blob;
import java.util.HashSet;

/*
 * @lc app=leetcode id=859 lang=java
 *
 * [859] Buddy Strings
 */

// @lc code=start
class Solution {
    public boolean buddyStrings(String a, String b) {
        int len = a.length();
        if (len != b.length()) {
            return false;
        }
        if (a.equals(b)) {
            // check if there are at least one duplicated char
            HashSet<Integer> set = new HashSet<>();
            for (int i=0; i<len; i++) {
                int c = a.charAt(i) - '0';
                if (set.contains(c)) {
                    return true;
                } else {
                    set.add(c);
                }
            }
            return false;
        } else {
            // check if we have 2 and only 2 chars difference
            int first = -1;
            int second = -1;
            for (int i=0; i<len; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    if (first == -1) {
                        // first difference
                        first = i;
                    } else if (second == -1) {
                        // second difference
                        second = i;
                    } else {
                        // the third
                        return false;
                    }
                }
            }

            if (second == -1) {
                // only 1 difference
                return false;
            } else if (a.charAt(first) == b.charAt(second) && a.charAt(second) == b.charAt(first)) {
                return true;
            } else {
                return false;
            }
        }
        
    }
}
// @lc code=end


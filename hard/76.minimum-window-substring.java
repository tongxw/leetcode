import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    private HashMap<Character, Integer> targetMap = new HashMap<>();
    private HashMap<Character, Integer> windowMap = new HashMap<>();

    public String minWindow(String s, String t) {
        char[] chars = s.toCharArray();
        int l = 0;
        int ansL = -1;
        int ansR = -1;

        char[] tChars = t.toCharArray();
        for (char c : tChars) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        
        int minLen = Integer.MAX_VALUE;
        for (int r=0; r<chars.length; r++) {
            if (targetMap.containsKey(chars[r])) {
                windowMap.put(chars[r], windowMap.getOrDefault(chars[r], 0) + 1);
            }
            while (targetExists() && l <= r) {
                // this window has all the chars in t string, now move left to shrink window size
                int windowLen = r - l + 1;
                if (windowLen < minLen) {
                    // update the result
                    minLen = windowLen;
                    ansR = r + 1;
                    ansL = l;
                }
                if (targetMap.containsKey(chars[l])) {
                    windowMap.put(chars[l], windowMap.getOrDefault(chars[l], 0) - 1);
                }

                l++;
            }
        }

        // ""cabwefgewcwaefgcf"\n"cae""
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    private boolean targetExists() {
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            if (windowMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }

        return true;
    }

    private String bruteForce(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        String res = "";
        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length; i++) {
            StringBuffer sb = new StringBuffer(t);
            for (int j=i; j<chars.length; j++) {
                if (sb.length() == 0) {
                    res = getMinString(res, s, i, j);
                    break;
                }
                int index = sb.toString().indexOf(chars[j]);
                if (index != -1) {
                    sb.deleteCharAt(index);
                }
            }
        }

        return res;
    }

    private String getMinString(String res, String s, int i, int j) {
        if (!res.isEmpty() && s.length() <= j - i + 1) {
            return res;
        } else {
            return s.substring(i, j+1);
        }
    }
}
// @lc code=end


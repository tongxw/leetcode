import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=467 lang=java
 *
 * [467] Unique Substrings in Wraparound String
 */

// @lc code=start
class Solution {
    public int findSubstringInWraproundString(String p) {
        int ans = 1;
        int pre = 1;
        // int l = 0;
        char[] chars = p.toCharArray();
        // HashSet<String> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(chars[0], 1);
        // set.add(Character.toString(chars[0]));
        for (int r=1; r<chars.length; r++) {
            if (chars[r] - chars[r-1] == 1 || (chars[r] == 'a' && chars[r-1] == 'z')) {
                pre += 1;
                // for (int i=l; i<=r; i++) {
                //     set.add(p.substring(i, r+1));
                int maxLen = Math.max(map.getOrDefault(chars[r], 0), pre);
                map.put(chars[r], maxLen);
                // }
            } else {
                pre = 1;
                // l = r;
                // set.add(Character.toString(chars[l]));
                int maxLen = Math.max(map.getOrDefault(chars[r], 0), pre);
                map.put(chars[r], maxLen);
                
            }

            // ""cac""
            ans += pre;
 
        }

        // return ans;
        // return set.size();
        ans = 0;
        for (int count : map.values()) {
            ans += count;
        }
        return ans;
    }
}
// @lc code=end


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    private int[] targets = new int[26];
    private int[] windows = new int[26];

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<Integer>();
        if (s.length() < p.length()) {
            return ans;
        }

        for (char c : p.toCharArray()) {
            targets[c - 'a'] += 1; 
        }
        
        int l = 0;
        int r = 0;
        char[] chars = s.toCharArray();
        
        for (; r<p.length() - 1; r++) {
            windows[chars[r] - 'a'] += 1;
        }

        for (; r<chars.length;l++, r++) {
            windows[chars[r] - 'a'] += 1;
            if (anagram()) {
                ans.add(l);
            }
            windows[chars[l] - 'a'] -= 1;
        }

        return ans;
    }

    private boolean anagram() {
        for (int i=0; i<26; i++) {
            if (targets[i] != windows[i]) {
                return false;
            }
        }
    
        return true;
    }
}
// @lc code=end


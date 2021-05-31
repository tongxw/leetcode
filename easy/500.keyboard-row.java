import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode id=500 lang=java
 *
 * [500] Keyboard Row
 */

// @lc code=start
class Solution {
    public String[] findWords(String[] words) {
        ArrayList<String> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
    
        char[] firstLine = new String("qwertyuiop").toCharArray();
        char[] secondLine = new String("asdfghjkl").toCharArray();
        char[] thirdLine = new String("zxcvbnm").toCharArray();
        for (char c : firstLine) {
            map.put(c, 1);
        }
        for (char c : secondLine) {
            map.put(c, 2);
        }
        for (char c : thirdLine) {
            map.put(c, 3);
        }

        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();
            int len = lowerCaseWord.length();
            if (len == 0) {
                continue;
            }
            int lineNumber = map.get(lowerCaseWord.charAt(0));
            int i=1;
            for (; i<len; i++) {
                char c = lowerCaseWord.charAt(i);
                if (lineNumber != map.get(c)) {
                    break;
                }
            }
            if (i == len) {
                res.add(word);
            }
        }

        return res.toArray(new String[0]);
        
    }
}
// @lc code=end


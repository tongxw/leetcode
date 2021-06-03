import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jdk.javadoc.internal.doclets.formats.html.resources.standard_ja;

/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */

// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length();
        int totalLen = words.length * wordLen;

        HashMap<String, Integer> wordsCounter = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int r=0; r<s.length() - totalLen + 1; r++) {
            String strWin = s.substring(r, r+totalLen);
            resetCount(wordsCounter, words);

            int i = 0;
            for (; i<strWin.length(); i+=wordLen) {
                String word = strWin.substring(i, i+wordLen);
                if (!wordsCounter.containsKey(word)) {
                    // not match
                    break;
                }
                if (!setExistingWord(wordsCounter, word)) {
                    // not match
                    break;
                }
            }
            if (i == strWin.length()) {
                // match
                ans.add(r);
            }
        }

        //"wordgoodgoodgoodbestword"\n["word","good","best","word"]
        //"barfoofoobarthefoobarman"\n["bar","foo","the"]
        //"aaaaaaaaaaaaaa"\n["aa", "aa"]
        return ans;
    }

    private List<Integer> myFirstSolution(String s, String[] words) {
        int wordLen = words[0].length();

        HashMap<String, Integer> wordsInWindow = new HashMap<>();
        resetCount(wordsInWindow, words);

        ArrayList<Integer> ans = new ArrayList<>();

        int l = 0;
        int r = 0;
        while (r<s.length()) {
            if (r + wordLen > s.length()) {
                break;
            }

            String newWord = s.substring(r, r+wordLen);
            // System.out.println("check word: " + newWord + " start index: " + l);
            if (!setExistingWord(wordsInWindow, newWord)) {
                // System.out.println("word: " + newWord + " not exist, left: " + l + " right: " + r);
                resetCount(wordsInWindow, words);

                // next search begins from l + 1
                l += 1;
                r = l;
                continue;
            }

            if (allWordsExist(wordsInWindow)) {
                ans.add(l);
                resetCount(wordsInWindow, words);

                // next search begins from l + 1
                l += 1;
                r = l;
                continue;
            }

            // go check next word
            r += wordLen;
        }
        
        //"wordgoodgoodgoodbestword"\n["word","good","best","word"]
        //"barfoofoobarthefoobarman"\n["bar","foo","the"]
        //"aaaaaaaaaaaaaa"\n["aa", "aa"]
        return ans;
    }

    private boolean allWordsExist(HashMap<String, Integer> wordsInWindow) {
        for (Integer count : wordsInWindow.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    private boolean setExistingWord(HashMap<String, Integer> wordsInWindow, String word) {
        if (wordsInWindow.containsKey(word) && wordsInWindow.get(word) > 0) {
            wordsInWindow.put(word, wordsInWindow.get(word) - 1);

            // System.out.println("word: " + word );

            return true;
        } else {
            return false;
        }
    }

    private void resetCount(HashMap<String, Integer> wordsInWindow, String[] words) {
        wordsInWindow.clear();;
        for (String word : words) {
            wordsInWindow.put(word, wordsInWindow.getOrDefault(word, 0) + 1);
        }
    }
}
// @lc code=end


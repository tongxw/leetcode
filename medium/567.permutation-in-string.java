/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 * [array][sliding-window]
 * 注意看题，这题有substring的关键字！
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }

        int l = 0;
        int r = len1 - 1;
        String strInWindow;
        while (r < s2.length()) {
            strInWindow = s2.substring(l, r+1);
            if (isPermutation(s1, strInWindow)) {
                //System.out.println("win str: " + strInWindow);
                return true;
            }

            l++;
            r++;
        }

        // ""kitten"\n"sitting""
        return false;
    }

    private boolean isPermutation(String s1, String s2) {
        // int xor = 0;
        // for (char c : s1.toCharArray()) {
        //     xor ^= c - 'a';
        // }

        // for (char c : s2.toCharArray()) {
        //     xor ^= c - 'a';
        // }

        // return xor == 0;
        int[] letters = new int[26];
        for (char c : s1.toCharArray()) {
            letters[c - 'a'] += 1;
        }

        for (char c : s2.toCharArray()) {
            letters[c - 'a'] -= 1;
            if (letters[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=1737 lang=java
 *
 * [1737] Change Minimum Characters to Satisfy One of Three Conditions
 * [enum][stat]
 */

// @lc code=start
class Solution {
    public int minCharacters(String a, String b) {
        // count all the letters from a and b
        int[] countA = new int[26];
        int[] countB = new int[26];
        for (char c : a.toCharArray()) {
            countA[c - 'a'] += 1;
        }
        for (char c : b.toCharArray()) {
            countB[c - 'a'] += 1;
        }

        int ans = Integer.MAX_VALUE;
        for (int k=0; k<26; k++) {
            int counter = 0;
            if (k > 0) {
                // case1, max(a) < min(b)
                ans = Math.min(ans, getChanges(countA, countB, k));

                // case2, max(b) < min(a), same as case 1
                ans = Math.min(ans, getChanges(countB, countA, k));
            }

            // case3, change every letter to k
            counter = 0;
            for (int i=0; i<26; i++) {
                if (i != k) {
                    counter += countA[i];
                    counter += countB[i];
                }
            }

            ans = Math.min(ans, counter);
        }

        return ans;
    }

    private int getChanges(int[] countA, int[] countB, int k) {
        if (k == 0) {
            return Integer.MAX_VALUE;
        }

        int counter = 0;
        for (int i=k; i<26; i++) { // if (char x in a) >= char k, change it to k-1
            counter += countA[i];
        }
        for (int i=0; i<k; i++) { // if (char x in b) < k, change it to k
            counter += countB[i];
        }
        return counter;
    }
}
// @lc code=end


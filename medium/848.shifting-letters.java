/*
 * @lc app=leetcode id=848 lang=java
 *
 * [848] Shifting Letters
 * [array][preSum]
 */

// @lc code=start
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        // first, we can calculate how many shifts for each chars in s
        // for example, if shifts = [3, 5, 9]
        // then for s[2], shift() count is 9
        // for s[1], shift() count is shifts[2] + shift[1] = 14
        // for s[0], shift() count is shifts[1+2+3] = 17
        // we also need to mod the result with 26 cuz shift(z) = a;
        // after we get the shifts, we can shift the chars and get the new s
        int n = shifts.length;
        int[] shiftCounts = new int[n];
        shiftCounts[n - 1] = shifts[n-1];
        for (int i=n-2; i>=0; i--) {
            shiftCounts[i] = (shiftCounts[i + 1] + shifts[i]) % 26;
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            int shift = (c - 'a' + shiftCounts[i]) % 26;
            char newC = (char)('a' + shift);
            //System.out.println("c: " + c + " shift: " + shift + " new: " + newC);
            ans.append(newC);
        }

        // "bad"\n[10,20,30]
        return ans.toString();
    }

    private String clean(String s, int[] shifts) {
        StringBuilder ans = new StringBuilder();
        int X = 0;
        for (int shift: shifts)
            X = (X + shift) % 26;

        for (int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i) - 'a';
            ans.append((char) ((index + X) % 26 + 97));
            X = Math.floorMod(X - shifts[i], 26);
        }

        return ans.toString();
    }
}
// @lc code=end


import java.util.HashMap;

/*
 * @lc app=leetcode id=1234 lang=java
 *
 * [1234] Replace the Substring for Balanced String
 */

// @lc code=start
class Solution {
    public int balancedString(String s) {
        int[] counts = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            ++counts[c - 'A'];
        }

        // key: we need to check the chars "outside" the window
        int l = 0;
        int ans = Integer.MAX_VALUE;
        int k = chars.length / 4;
        for (int r=0; r<chars.length; r++) {
            --counts[chars[r] - 'A'];
            // if all Qs Ws Es Rs are less than len/4 outside the window, then if we change letters inside
            // the window, eventually it will be balanced.
            // we don't need to care how to change the letters inside window
            while (l < chars.length && counts['Q' - 'A'] <= k && counts['W' - 'A'] <= k &&
                   counts['E' - 'A'] <= k && counts['R' - 'A'] <= k) {
                ans = Math.min(ans, r - l + 1);
                ++counts[chars[l] - 'A'];
                l++;
            }
        }

        return ans;
    }

    private int myFirstSolution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int balance = chars.length / 4;

        int q = map.getOrDefault('Q', 0);
        int w = map.getOrDefault('W', 0);
        int e = map.getOrDefault('E', 0);
        int r = map.getOrDefault('R', 0);
        
        // System.out.println("Q: " + q + " W: " + w + " E:" + e + " R:" + r + " ->" + balance);

        q = q > balance ? q - balance : 0;
        w = w > balance ? w - balance : 0;
        e = e > balance ? e - balance : 0;
        r = r > balance ? r - balance : 0;
        if (q == 0 && w == 0 && e == 0 && r == 0) {
            return 0;
        }

        int left = 0;
        int ans = Integer.MAX_VALUE;
        for (int right=0; right<chars.length; right++) {
            // updateWindow(char[right]);
            q -= increase(chars[right], 'Q');
            w -= increase(chars[right], 'W');
            e -= increase(chars[right], 'E');
            r -= increase(chars[right], 'R');
            while(q <= 0 && w <=0 && e <=0 && r<=0) {
                ans = Math.min(ans, right - left + 1);
                q += increase(chars[left], 'Q');
                w += increase(chars[left], 'W');
                e += increase(chars[left], 'E');
                r += increase(chars[left], 'R');
                left++;
            }
            // while(containsBalanceChars(chars, left, right, q, w, e, r)) {
            //     ans = Math.min(ans, right - left + 1);
            //     left++;
            // }
        }

        // ""WWEQERQWQWWRWWERQWEQ""
        return ans;
    }

    private int increase(char c, char qwer) {
        return c == qwer ? 1 : 0;
    }

    private boolean containsBalanceChars(char[] chars, int left, int right, int q, int w, int e, int r) {
        for (int i=left; i<=right; i++) {
            char c = chars[i];
            q -= (c == 'Q') ? 1 : 0;
            w -= (c == 'W') ? 1 : 0;
            e -= (c == 'E') ? 1 : 0;
            r -= (c == 'R') ? 1 : 0;

            if (q <= 0 && w <=0 && e <=0 && r<=0) {
                return true;
            }
        }

        return false;
    }
}
// @lc code=end


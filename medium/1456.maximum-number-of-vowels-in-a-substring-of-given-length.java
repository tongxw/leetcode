import java.nio.charset.CharsetDecoder;

import javax.print.attribute.standard.PresentationDirection;

/*
 * @lc app=leetcode id=1456 lang=java
 *
 * [1456] Maximum Number of Vowels in a Substring of Given Length
 */

// @lc code=start
class Solution {
    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        // int[] preSums = new int[s.length() + 1];
        // for (int i=0; i<chars.length; i++) {
        //     int count = isVowel(chars[i]) ? 1 : 0;
        //     if (i == 0) {
        //         preSums[i] = count;
        //     } else {
        //         preSums[i] = count + preSums[i-1];
        //     }
        // }

        int ans = 0;
        int l = 0;
        int r = k - 1;
        // while (r < chars.length) {
        //     int count = preSums[r];
        //     if (l > 0) {
        //         count = preSums[r] - preSums[l-1];
        //     }
        //     ans = Math.max(ans, count);
        //     l++;
        //     r++;
        // }

        // return ans;


        // actually no need to use presums
        ans = 0;
        for (r=0; r<=k-1; r++) {
            ans += isVowel(chars[r]) ? 1 : 0;

        }

        int total = ans; // vowels in [0, k-1]
        System.out.println("sub: " + s.substring(l, l+k) + " vowels: " + total);
        r = k - 1; // KEY: currently r = k. need to set the r to k-1 !!!!
        while (r < chars.length - 1) {
            // next move
            total += isVowel(chars[r+1]) ? 1 : 0;
            total -= isVowel(chars[l]) ? 1 : 0;
            ans = Math.max(ans, total);

            l++;
            r++;
        }

        //"weallloveyou"\n7
        // "tryhard"\n4
        return ans;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' ||c == 'u';
    }
}
// @lc code=end


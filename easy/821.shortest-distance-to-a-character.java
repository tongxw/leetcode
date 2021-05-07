import java.util.ArrayList;

import jdk.internal.PreviewFeature;

/*
 * @lc app=leetcode id=821 lang=java
 *
 * [821] Shortest Distance to a Character
 */

// @lc code=start
class Solution {
    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] res = new int[len];

        // // Solution 1
        // // first, get all the indexes of c in s
        // ArrayList<Integer> arr = new ArrayList<Integer>();
        // for (int i=0; i<len; i++) {
        //     if (s.charAt(i) == c) {
        //         arr.add(i);
        //     }
        // }

        // // for each char in s, get the min value of (s - index)
        // for (int i=0; i<len; i++) {
        //     int min = len;
        //     for (int j: arr) {
        //         min = Math.min(Math.abs(i-j), min);
        //     }
        //     res[i] = min;
        // }

        // // time: O(n), space O(n)
        // return res;

        // Solution 2
        // double check <-- target -->
        // for (int i=0; i<len; i++) {
        //     // char cur = s.charAt(i);

        //     // look forward <=
        //     int j, k;
        //     for (j=i; j>=0; j--) {
        //         if (s.charAt(j) == c) {
        //             break;
        //         }
        //     }
        //     // look backward =>
        //     for (k=i; k<len; k++) {
        //         if (s.charAt(k) == c) {
        //             break;
        //         }
        //     }
        //     if (j == -1) {
        //         j = -10000;
        //     }
        //     if (k == len) {
        //         k = 10000;
        //     }
        //     res[i] = Math.min(i-j, k-i);
        // }

        // // time O(n2), space O(1)
        // return res;

        // Solution 3
        // from 1st to last, for each char, get the diffenrece between the char and pre-exist target
        int prevIndex = -10000;
        for (int i=0; i<len; i++) {
            if (s.charAt(i) == c) {
                prevIndex = i;
            }
            res[i] = i - prevIndex;
        }

        // from last to 1st, for each char, get the difference between the char and the pre-exist target
        int backIndex = 10000;
        for (int i=len-1; i>=0; i--) {
            if (s.charAt(i) == c) {
                backIndex = i;
            }

            res[i] = Math.min(res[i], backIndex - i);
        }

        // time: O(n), space: O(1)
        return res;
    }
}
// @lc code=end


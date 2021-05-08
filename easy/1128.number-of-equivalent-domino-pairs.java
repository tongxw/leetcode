import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=1128 lang=java
 *
 * [1128] Number of Equivalent Domino Pairs
 */

// @lc code=start
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        // HashMap<String, Integer> map = new HashMap<>();
        // for (int[] domino: dominoes) {
        //     String dominoStr = "";
        //     if (domino[0] > domino[1]) {
        //         dominoStr = domino[0] + " " + domino[1];
        //     } else {
        //         dominoStr = domino[1] + " " + domino[0];
        //     }
        //     if (map.containsKey(dominoStr)) {
        //         map.put(dominoStr, map.get(dominoStr) + 1);
        //     } else {
        //         map.put(dominoStr, 0);
        //     }
        // }

        // int total = 0;
        // for (int count : map.values()) {
        //     if (count == 0) {
        //         continue;
        //     }
        //     total += (count + 1) * count / 2;
        // }

        // return total;
        // [[1,1],[2,2],[1,1],[1,2],[1,2],[1,1]]

        // // solution 2
        // // since the number is [1, 9], we could use 5 bit to save this number
        // // for dominoes, it has two numbers, so it can be compressed to 10 bit
        // // the compressed array size should be 2^10
        // int[] compressed = new int[1024];
        // int total = 0;
        // for (int[] d: dominoes) {
        //     int c = 0;
        //     if (d[0] > d[1]) {
        //         c = d[0] << 5 | d[1];
        //     } else {
        //         c = d[1] << 5 | d[0];
        //     }
        //     total += compressed[c];
        //     compressed[c] += 1;
        // }

        // return total;

        // Solution 3: actually, the d[0]d[1] can be considered as a number base-9
        // so it can be saved as d[0] * 9 + d[1]
        int[] compressed = new int[90];
        int total = 0;
        for (int[] d: dominoes) {
            int c = Math.min(d[0] * 9 + d[1], d[1] * 9 + d[0]) - 1;
            total += compressed[c];
            compressed[c] += 1;
        }

        return total;
    }
}
// @lc code=end


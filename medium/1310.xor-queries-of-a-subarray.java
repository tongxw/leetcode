/*
 * @lc app=leetcode id=1310 lang=java
 *
 * [1310] XOR Queries of a Subarray
 */

// @lc code=start
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] preXors = new int[arr.length];
        preXors[0] = arr[0];
        for (int i=1; i<arr.length; i++) {
            preXors[i] = preXors[i-1] ^ arr[i];
        }

        int[] ans = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
            if (queries[i][0] > 0) {
                ans[i] = preXors[queries[i][0] - 1] ^ preXors[queries[i][1]];
            } else {
                ans[i] = preXors[queries[i][1]];
            }
        }

        return  ans;
    }
}
// @lc code=end


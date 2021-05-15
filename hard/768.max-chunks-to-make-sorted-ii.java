/*
 * @lc app=leetcode id=768 lang=java
 *
 * [768] Max Chunks To Make Sorted II
 */

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return 1;
        }

        int[] maxFromleft = new int[len];
        int[] minFromRight = new int[len];

        maxFromleft[0] = arr[0];
        for (int i=1; i<len; i++) {
            maxFromleft[i] = Math.max(maxFromleft[i-1], arr[i]);
        }

        minFromRight[len-1] = arr[len-1];
        for (int i=len-2; i>=0; i--) {
            minFromRight[i] = Math.min(minFromRight[i+1], arr[i]);
        }

        int count = 1;
        for (int i=0; i<len-1; i++) {
            if (maxFromleft[i] <= minFromRight[i+1]) {
                count++;
            }
        }

        // [0,1]
        // [1,0,2,3,4]
        return count;
    }
}
// @lc code=end


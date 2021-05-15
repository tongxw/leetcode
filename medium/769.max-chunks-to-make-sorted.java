/*
 * @lc app=leetcode id=769 lang=java
 *
 * [769] Max Chunks To Make Sorted
 */

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
        return generalSolution(arr);
        // return optimized(arr);
    }

    private int generalSolution(int[] arr) {
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

    private int optimized(int[] arr) {
        int count = 0;
        int max = 0;
        for (int i=0; i<arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end
 

import javax.print.attribute.standard.PresentationDirection;

/*
 * @lc app=leetcode id=1186 lang=java
 *
 * [1186] Maximum Subarray Sum with One Deletion
 */

// @lc code=start
class Solution {
    public int maximumSum(int[] arr) {
        return preSum(arr);
    }

    private int preSum(int[] arr) {
        // boundary, we need to keep at least one element
        if (arr.length == 1) {
            return arr[0];
        }

        // at index i, get the max pre sum from 0 to i
        int[] leftMaxPreSums = new int[arr.length];
        leftMaxPreSums[0] = arr[0];
        for (int i=1; i<arr.length; i++) {
            leftMaxPreSums[i] = Math.max(leftMaxPreSums[i-1] + arr[i], arr[i]);
        }

        // if we don't delete any element, max(LeftMaxPreSums) should be the answer;
        // if we delete one element at i, then the max sum at i is
        // leftMaxPreSums[i-1] + rightMaxPreSums[i+1];
        // so we need to first calculate the max preSums from [i,...,len-1]
        int[] rightMaxPreSums = new int[arr.length];
        rightMaxPreSums[arr.length-1] = arr[arr.length-1];
        for (int i=arr.length-2; i>=0; i--) {
            rightMaxPreSums[i] = Math.max(rightMaxPreSums[i+1] + arr[i], arr[i]);
        }

        // now get the answer
        int ans = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {
            int max = 0;
            int maxDelete = (i == 0 ? 0 : leftMaxPreSums[i-1]);
            maxDelete += (i == arr.length - 1 ? 0 : rightMaxPreSums[i+1]);
            max = Math.max(leftMaxPreSums[i], maxDelete);

            ans = Math.max(ans, max);
        }

        // [-50]
        return ans;
    }

    private int dp(int[] arr) {
        // tbd..
        return 0;
    }
}
// @lc code=end


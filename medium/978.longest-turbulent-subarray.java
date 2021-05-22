/*
 * @lc app=leetcode id=978 lang=java
 *
 * [978] Longest Turbulent Subarray
 */

// @lc code=start
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length <= 1) {
            return arr.length;
        }

        int l = 0;
        int ans = 0;
        int r = 1;
        for (; r<arr.length; r++) {
            if (!check(arr, l, r)) {
                // System.out.println("l: " + l + " r: " + r);
                ans = Math.max(ans,  r - l);
                l = r - 1;
            }
        }

        ans = Math.max(ans,  r - l);

        // [0,8,45,88,48,68,28,55,17,24]
        // [9, 9]
        return ans;
        
    }

    private boolean check(int[] arr, int l, int r) {
        int lastSign = 0; // 1 => arr[i] > arr[i-1] -1 => arr[i] < arr[i-1]
        for (int i=l; i<=r; i++) {
            if (i > l) {
                if (arr[i] == arr[i-1]) {
                    return false;
                }
                if ((arr[i] > arr[i-1] && lastSign == 1) || (arr[i] < arr[i-1] && lastSign == -1)) {
                    return false;
                } else {
                    lastSign = arr[i] > arr[i-1] ? 1 : -1;
                }
            }
        }



        return true;
    }
}
// @lc code=end


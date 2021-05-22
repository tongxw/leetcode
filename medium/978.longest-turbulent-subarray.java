/*
 * @lc app=leetcode id=978 lang=java
 *
 * [978] Longest Turbulent Subarray
 */

// @lc code=start
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int ans = 0;
        int l = 0;
        int r = 0;
        while (r < arr.length - 1) {
            if (l == r) {
                if (arr[r] == arr[r+1]) {
                    l++;
                }
                r++;
            } else {
                if ((arr[r - 1] < arr[r] && arr[r] > arr[r+1]) ||
                    (arr[r - 1] > arr[r] && arr[r] < arr[r + 1])) {
                    r++;
                } else {
                    l = r;
                }
            }

            ans = Math.max(ans, r - l + 1);
        }
        
        return ans;
    }

    private int myFirstSolution(int[] arr) {
        if (arr.length <= 1) {
            return arr.length;
        }

        int l = 0;
        int ans = 0;
        int r = 1;
        while (r<arr.length) {
            if (!check(arr, l, r)) {
                // update answer
                ans = Math.max(ans,  r - l);
                if (arr[r] == arr[l]) {
                    if (r == arr.length - 1) {
                        break;
                    } else {
                        l = r;
                    }
                } else {
                    l = r - 1;
                }
            } else if (r == arr.length - 1) {
                ans = Math.max(ans,  arr.length - l);
            }

            r++;
        }

        // [0,8,45,88,48,68,28,55,17,24]
        // [9, 9]
        // [100,100,100]
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


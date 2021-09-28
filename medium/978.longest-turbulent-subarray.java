/*
 * @lc app=leetcode id=978 lang=java
 *
 * [978] Longest Turbulent Subarray
 */

// @lc code=start
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        // dp(i) = max turbulence size for arr[0...i]
        // dp(0) = 1
        // dp(1) = 2
        // dp(2) = if a[1] > a[0] => { if a[2] < a[1] => dp(1) + 1, else => 1}
        //       = if a[1] < a[0] => { if a[2] > a[1] => dp(1) + 1, else => 1}
        // dp(i) = if a[i-1] > a[i-2] => { if a[i] < a[i-1] => dp(i-1) + 1, else => 2}
        //       = if a[i-1] < a[i-2] => { if a[i] > a[i-1] => dp(i-1) + 1, else => 2}
        // return max(dp(i))
        if (arr.length <= 1) {
            return arr.length;
        }
        

        int dp1 = 0;
        if (arr[0] == arr[1]) {
            dp1 = 1;
        } else {
            dp1 = 2;
        }
        
        
        int ans = dp1;
        int dp = 0;
        for (int i=2; i<arr.length; i++) {
            if (dp1 == 1) {
                if (arr[i] == arr[i-1]) {
                    dp = 1;
                } else {
                    dp = 2;
                }
            } else {
                if (arr[i-1] > arr[i-2]) {
                    if (arr[i] < arr[i-1]) {
                        dp = dp1 + 1;
                    } else if (arr[i] == arr[i-1]) {
                        dp = 1;
                    } else {
                        dp = 2;
                    }
                }

                if (arr[i-1] < arr[i-2]) {
                    if (arr[i] > arr[i-1]) {
                        dp = dp1 + 1;
                    } else if (arr[i] == arr[i-1]) {
                        dp = 1;
                    } else {
                        dp = 2;
                    }
                }
            }

            //System.out.println("idx: " + i + " dp: " + dp);
            ans = Math.max(ans, dp);
            dp1 = dp;
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


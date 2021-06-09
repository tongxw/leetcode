/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid == x) {
                return mid;
            } else if ((long) mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            // int div = (mid == 0 ? 0 : x / mid); // need to check: x != 0
            // if (mid == div) {
            //     return mid;
            // } else if (mid < div) {
            //     left = mid + 1;
            // } else {
            //     right = mid - 1;
            // }
        }

        // 2147395599
        return left - 1;
    }
}
// class Solution {
//     public int mySqrt(int x) {
//         int l = 0, r = x, ans = -1;
//         while (l <= r) {
//             int mid = l + (r - l) / 2;
//             if ((long) mid * mid <= x) {
//                 ans = mid;
//                 l = mid + 1;
//             } else {
//                 r = mid - 1;
//             }
//         }
//         return ans;
//     }
// }
// @lc code=end


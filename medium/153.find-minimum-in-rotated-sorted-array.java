/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    //TODO
    // https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/er-fen-cha-zhao-wei-shi-yao-zuo-you-bu-dui-cheng-z/
    public int findMin(int[] nums) {
        // int l = 0;
        // int r = nums.length - 1;
        // while (l < r) {
        //     int mid = l + (r - l) / 2;

        //     // check the last num
        //     // if the mid number is to the right of the min number, it must be smaller than nums[r]
        //     // or else, the mid num is to the left of the min number, it must be bigger than nums[r]
        //     if (nums[mid] < nums[r]) {
        //         // min is in [l, mid]
        //         r = mid;
        //     } else {
        //         // min is in [mid+1, r]
        //         l = mid + 1;
        //     }
        // }

        // return nums[l];

        return findMax(nums);
    }

    private int findMax(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[l] < nums[mid]) {
                // max is in [mid, r]
                l = mid;
            } else if (nums[l] > nums[mid])  {
                // max is in [l, mid-1]
                r = mid - 1;
            } else {
                break;
            }
        }

        return nums[r];
    }

    // The minimum element must satisfy one of two conditions:
    //  1) If rotate, A[min] < A[min - 1];
    //  2) If not, A[0]. Therefore, we can use binary search:
    //     check the middle element, if it is less than previous one, then it is minimum.
    //     If not, there are 2 conditions as well: If it is greater than both left and right element, then minimum element should be on its right, otherwise on its left.
    private int topVoted(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[start] <= nums[mid] && nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return nums[start];
    }
}
// @lc code=end


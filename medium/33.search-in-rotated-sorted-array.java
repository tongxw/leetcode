/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println(mid);
            if (target == nums[mid]) {
                return mid;
            } else {
                if (nums[low] <= nums[mid]) { // [0, mid-1] is sorted => same as nums[0] <= nums[mid]
                    if (nums[low] <= target && target < nums[mid]) {
                        high = mid - 1; // next search: [low, mid - 1]
                    } else {
                        low = mid + 1; // next search [mid + 1, high]
                    }
                } else { // [mid + 1, len-1] is sorted array
                    if (nums[mid] < target && target <= nums[high]) {
                        low = mid + 1; // next search: [mid + 1, high]
                    } else {
                        high = mid - 1; // next search [low, mid - 1]
                    }
                }
            }
        }

        //[1,3]\n3
        //[1,3]\n2
        //[1,3,5]\n1
        return -1;
    }
}
// @lc code=end


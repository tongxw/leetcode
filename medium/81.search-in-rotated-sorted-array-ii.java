/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            } else {
                // how to get rid of the half: which part is sorted?
                while (l < mid && nums[l] == nums[mid]) {
                    // KEY part
                    // we need to get rid of the extra same nums
                    // different from #33
                    l++;
                }

                if (nums[l] <= nums[mid]) {
                    // [l, mid-1] is sorted
                    if (nums[l] <= target && target < nums[mid]) {
                        // target is here, go next search
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    // [mid+1, r] is sorted
                    if (nums[mid] < target && target <= nums[r]) {
                        // target is here, go next search
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
        }

        return false;

    }
}
// @lc code=end


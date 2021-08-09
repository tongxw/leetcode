/*
 * @lc app=leetcode id=912 lang=java
 *
 * [912] Sort an Array
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    private void mergeSort(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid, temp);
        mergeSort(nums, mid + 1, end, temp);
        merge(nums, start, mid, end, temp);
    }

    private void merge(int[] nums, int start, int mid, int end, int[] temp) {
        int i = start;
        int j = mid + 1;
        int idx = 0;

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[idx++] = nums[i++];
            } else {
                temp[idx++] = nums[j++];
            }
        }


        while (i <= mid) {
            temp[idx++] = nums[i++];
        }
        
        while (j <= end) {
            temp[idx++] = nums[j++];
        }

        idx = 0;
        for (int k=start; k<=end; k++) {
            nums[k] = temp[idx++];
        }
    }
}
// @lc code=end


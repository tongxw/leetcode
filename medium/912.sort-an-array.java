/*
 * @lc app=leetcode id=912 lang=java
 *
 * [912] Sort an Array
 * [sort][array][must]
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        return bubbleSort(nums);
    }

    private int[] quickSortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        int pivot = nums[mid];

        // 2 pointers
        int i = start;
        int j = end;

        // System.out.println("start: " + i + " end: " + j);

        while (i <= j) {
            while (nums[i] < pivot) {
                i++;
            }
            while (nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        // now, i > j && nums[i] >= pivot && nums[j] <= pivot
        // sorted array from j+1 => i-1

        // System.out.println("i: " + i + " j: " + j);

        quickSort(nums, start, j);
        quickSort(nums, i, end);
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    private int[] mergeSortArray(int[] nums) {
        // REMEMBER to define a helper temp array when do merge sort!!!
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

    // LC 88, merge sorted  array
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

    private int[] bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n-i-1; j++) {
                if (nums[j] > nums[j+1]) {
                    swap(nums, j, j+1);
                }
            }
        }

        return nums;
    }
}
// @lc code=end


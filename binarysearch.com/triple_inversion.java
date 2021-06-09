https://binarysearch.com/problems/Triple-Inversion

import java.util.*;

class Solution {
    private int count = 0;
    public int solve(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return count;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        merge(nums, left, mid, right, temp);
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;

        while (i<= mid && j<=right) {
            if (nums[i] <= nums[j] * 3) {
                i++;
            } else {
                count += mid - i + 1;
                j++;
            }
        }

        // sort
        i = left;
        j = mid + 1;
        int index = 0;
        while (i<=mid && j<=right) {
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
                temp[index++] = nums[j++];
            }
        }
        while (i<=mid) {
            temp[index++] = nums[i++];
        }
        while (j<=right) {
            temp[index++] = nums[j++];
        }

        index = 0;
        for (i=left; i<=right; i++) {
            nums[i] = temp[index++];
        }
    }
}

// Binary Search Solution (Time Exceeded)
class Solution {
    public int solve(int[] nums) {
        ArrayList<Integer> visited = new ArrayList<>();
        int ans = 0;
        for (int i=0; i<nums.length; i++) {
            ans += binarySearchRight(visited, nums[i] * 3);
            visited.add(nums[i]);
            Collections.sort(visited);
        }
        
        return ans;

    }

    private int binarySearchRight(ArrayList<Integer> arr, int num) {
        if (arr.size() == 0) {
            return 0;
        }

        int l = 0;
        int r = arr.size() - 1;
        while (l<=r) {
            int mid = l + (r-l)/2;
            if (arr.get(mid) <= num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return arr.size() - l;
    }
}
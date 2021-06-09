/*
 * @lc app=leetcode id=493 lang=java
 *
 * [493] Reverse Pairs
 */

// @lc code=start
class Solution {
// https://leetcode-cn.com/problems/reverse-pairs/solution/shou-hua-tu-jie-yi-bu-yi-bu-jie-xi-gui-bing-pai-xu/
    private int count = 0;
    public int reversePairs(int[] nums) {    
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length-1, temp);

        // for (int num : nums) {
        //     System.out.print(num);
        // }

        //[2147483647,2147483647,2147483647,2147483647,2147483647,2147483647]
        // System.out.println(nums[0]* 2);
        return count;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid+1, right, temp);
        merge(nums, left, mid, right, temp);

        
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;

        // check the reverse pairs
        while(i<=mid && j<=right) {
            if ((long)nums[i] <= 2 * (long)nums[j]) {
                i++;
            } else {
                // System.out.println("mid: " + nums[mid] + " i: " + i + nums[i] + " j: " + j + nums[j]);
                count += mid - i + 1;
                j++;
            }
        }

        // do the merge
        i = left;
        j = mid + 1;
        int k = 0;
        while (i<=mid && j<=right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i<=mid) {
            temp[k++] = nums[i++];
        }
        while (j<=right) {
            temp[k++] = nums[j++];
        }

        k = 0;
        for (i=left; i<=right; i++) {
            nums[i] = temp[k++];
            // System.out.print(nums[i]);
        }
        // System.out.println("");
    }
}
// @lc code=end


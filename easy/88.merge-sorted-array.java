/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 * [sort][array]
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // for (int i=0, j=0; i<nums1.length && j<n; ) {
        //     if (nums1[i] > nums2[j]) {
        //         // push nums1 to back, from i to m-1, leave a blank
        //         for (int k=m; k-1>=i; k--) {
        //             nums1[k] = nums1[k-1];
        //         }

        //         // now we have one more element in nums1
        //         m++;
                
        //         // then set the value
        //         nums1[i] = nums2[j];

        //         // now this nums2 is merged to nums1
        //         // next loop, compare next nums1 and nums2
        //         i++;
        //         j++;
        //     } else {
        //         if (i>=m) {
        //             // compare complete, now append nums2
        //             nums1[i++] = nums2[j++];
        //         } else {
        //             // check next nums1 with current nums2
        //             i++;
        //         }

        //     }
        // }


        // solution 2. backward compare & merge
        int i=m-1, j=n-1, k=m+n-1;
        while (i>=0 && j>=0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j>=0) {
            // append
            nums1[k--] = nums2[j--];
        }
    }
}
// @lc code=end


import java.util.*;

/*
 * @lc app=leetcode id=327 lang=java
 *
 * [327] Count of Range Sum
 */

// @lc code=start
class Solution {
    // TODO
    // https://leetcode-cn.com/problems/count-of-range-sum/solution/qu-jian-he-de-ge-shu-by-leetcode-solution/
    private long[] temp = null;
    public int countRangeSum(int[] nums, int lower, int upper) {
        int minRange = 0;
        int maxRange = 0;

        long[] preSums = new long[nums.length + 1];
        temp = new long[nums.length + 1];
        preSums[0] = 0;
        for (int i=0; i<nums.length; i++) {
            preSums[i+1] = preSums[i] + nums[i];
        }

        for (long sum : preSums) {
            System.out.print(sum + ", ");
        }
        System.out.println("");
        int ans = countMergeSort(preSums, lower, upper, 0, preSums.length - 1);
        // for (long sum : preSums) {
        //     System.out.print(sum + ", ");
        // }

        return ans;

    }

    private int countMergeSort(long[] preSums, int lower, int upper, int start, int end) {
        // sum(i, j) = preSums[j] - preSums[i]
        if (start >= end) {
            return 0;
        }

        int mid = start + (end - start) / 2;
        // System.out.println("start: " + start + " end: " + end + " mid: " + mid);
        int n1 = countMergeSort(preSums, lower, upper, start, mid);
        int n2 = countMergeSort(preSums, lower, upper, mid+1, end);
        int ret = n1 + n2;

        // now we have two ordered sub arrays
        // all indexes in n1 array are less than indexes in n2 array, i.e, i <= j
        // now we need to calculate how many arrays start index (i) from n1 and end index (j) from n2, and also satisfy,
        // lower <= preSum[j] - preSums[i] <= upper


        // => sliding window [l, r],
        // find l, where preSums[l] - preSums[i] >= lower
        // find r, where preSums[r] <= upper + preSums[i]
        // then all [l, r] should satisfy, ret += r - l + 1;

        int i = start; // n1 array
        int left = mid + 1; // n2 array
        int right = mid + 1; // n2 array
        // System.out.println("l: " + left + " r: " + right);
        while (i <= mid) {
            while (left <= end && preSums[left] - preSums[i] < lower) {
                left++;
            }

            while (right <= end && preSums[right] - preSums[i] <= upper) {
                right++; // right move the next step
            }


            // System.out.println("res l: " + left + " r: " + right);
            ret += right-left;

            // check next n1, since the next n1 is bigger, we can use the previous [l, r]
            i++;
        }

        merge(preSums, start, mid, end);
        return ret;
    }

    private void merge(long[] sums, int start, int mid, int end) {
        int i = start;
        int j = mid+1;
        int index = 0;
        while (i <= mid && j <= end) {
            if (sums[i] <= sums[j]) {
                temp[index++] = sums[i++];
            } else {
                temp[index++] = sums[j++];
            }
        }

        while (i <= mid) {
            temp[index++] = sums[i++];
        }

        while (j <= end) {
            temp[index++] = sums[j++];
        }

        for (i=start, index=0; i<=end; i++, index++) {
            sums[i] = temp[index];
        }
    }

}
// @lc code=end


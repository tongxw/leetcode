/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] ans = new int[nums.length];

        // the bigger square is at the both sides of the original array
        for (int i=ans.length-1; i>=0; i--) {
            if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                ans[i] = nums[left] * nums[left];
                left++;
            } else {
                ans[i] = nums[right] * nums[right];
                right--;
            }
        }

        return ans;
    }

    // this is just overthinking...
    private int[] tooComplicated(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int target = 1;

        // find the number == 0 or the index to insert 0
        int index = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            // System.out.println(mid);
            if (nums[mid] == 0) {
                index = mid;
                break;
            } else if (nums[mid] > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left > right) {
            index = left;
        }

        // now generate the answer array
        int[] ans = new int[nums.length];
        ans[0] = nums[index] * nums[index];
        left = index - 1;
        right = index + 1;
        int i = 1;
        while (left >= 0 || right < nums.length) {
            int leftSq = left >= 0 ? nums[left] * nums[left] : 0;
            int rightSq = right < nums.length ? nums[right] * nums[right] : 0;
            if (leftSq != 0 && rightSq != 0) {
                // smaller one, then larger one
                ans[i++] = leftSq < rightSq ? leftSq : rightSq;
                ans[i++] = leftSq < rightSq ? rightSq : leftSq;
            } else if (leftSq != 0) {
                ans[i++] = leftSq;
            } else if (rightSq != 0) {
                ans[i++] = rightSq;
            }


            left--;
            right++;
        }

        return ans;
    }
}
// @lc code=end


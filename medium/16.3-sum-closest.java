/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 3 pointers, Sort + two pointer search. TC: O(NLogN)
        Arrays.sort(nums);
        int result = 0;
        int closest = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum > target) {
                    // we need to add a smaller number to sum
                    high--;
                } else {
                    // we need to add a bigger number to sum
                    low++;
                }

                int diff = sum > target ? sum - target : target - sum;
                if (diff < closest) {
                    closest = diff;
                    result = sum;
                }
            }
        }

        return result;
    }

    public int bruteForce(int[] nums, int target) {
        int sumCloset = Integer.MAX_VALUE;
        int ans = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                for (int k=j+1; k<nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int diff = sum > target ? sum - target : target - sum;
                    if (diff < sumCloset) {
                        sumCloset = diff;
                        ans = sum;
                    }
                }
            }
        }

        return ans;
    }
}
// @lc code=end


import java.util.Stack;

/*
 * @lc app=leetcode id=581 lang=java
 *
 * [581] Shortest Unsorted Continuous Subarray
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        // find the left most index i and right most index j, which will meet the following requirements:
        // array in [0, i] + [j, len-1] is a sorted array

        return bruteForce(nums);
    }

    // 
    private int bruteForce(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            for (int j=i; j<nums.length; j++) {
                int minK = Integer.MAX_VALUE;
                int maxK = Integer.MIN_VALUE;
                for (int k=i; k<j; k++) {
                    minK = Math.min(minK, nums[k]);
                    maxK = Math.max(maxK, nums[k]);
                }

                // check if all num in nums[0,...i-1] < minK
            }
        }
    }



    // time: O(nLogn), space: O(n)
    private int sort(int[] nums) {
        int[] numsSorted = nums.clone();
        Arrays.sort(numsSorted);
        int leftMost = nums.length;
        int rightMost = -1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != numsSorted[i]) {
                leftMost = Math.min(leftMost, i);
                rightMost = Math.max(rightMost, i);
            }
        }

        return leftMost == nums.length ? 0 : rightMost - leftMost + 1;

    }

    // time: O(n), space: O(n)
    private int monotoneStack(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int firstIndex = nums.length;
        int secondIndex = -1;
        for (int i=0; i<nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                firstIndex = Math.min(firstIndex, stack.pop());
            }
            stack.push(i);
        }

        // key: find the second index from the end of the nums!
        stack.clear();
        for (int i=nums.length-1; i>=0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                secondIndex = Math.max(secondIndex, stack.pop());
            }
            stack.push(i);
        }

        // [1,3,2,2,2]
        // [1,3,2]
        // [1,2,3,3,3]
        // [1,3,2,3,3]
        return firstIndex == nums.length ? 0 : secondIndex - firstIndex + 1;
    }
}
// @lc code=end


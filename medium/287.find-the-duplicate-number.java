/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        // return binarySearch(nums);
        return linkedListCycle(nums);
    }

    //TODO review
    private int linkedListCycle(int[] nums) {
        // treat the nums array as a linked-list: 0 -> nums[0] -> nums[nums[0]] -> .... 
        // if there is a duplicated number, this list must have a cycle.
        // the duplicated number is the beginning node of the cycle.
        // same as #142
        int slow = 0;
        int fast = 0;

        // linked-list: 0 -> nums[0] -> nums[nums[0]] -> .... 
        slow = nums[slow]; //slow = slow.next;
        fast = nums[nums[fast]]; //fast = fast.next.next;

        // slow meets fast 1st time
        while (slow != fast) {
            slow = nums[slow]; //slow = slow.next;
            fast = nums[nums[fast]]; //fast = fast.next.next;
        }

        // set fast to the list head
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }


    private int binarySearch(int[] nums) {
        int min = 1;
        int max = nums.length - 1;

        // Time: O(nLogn)
        while (min < max) {
            int mid = (min + max) / 2;
            
            // count how many numbers <= mid
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            
            // Pigeonhole principle
            if (count > mid) {
                // the duplicated number must be in left ~ mid
                max = mid;
            } else {
                // the duplicated number must be in mid + 1 ~ right
                min = mid + 1;
            }
        }

        return min;
    }

    private int bruteForce(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }

        return 0;
    }
}
// @lc code=end


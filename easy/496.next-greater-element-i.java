import java.util.HashMap;

/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 * [stack][monostack]
 * 这道题的提示信息是求下一个最大的元素
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // hashmap to save: nums2[i] -> next greater of nums2[i]
        // we can use a monostack to track the next greater of the num
        // monostack: from top to bottom, the number increases
        // when iterating the nums2 array, if current number is <= stack.top(), push the current number to the stack;
        // if the current number is greater than stack.top(), pop the stack until current number <= stack.top(), and
        // this current number is the next greater number of all popped num
        Map<Integer, Integer> map = new HashMap<>(); // num -> next greater of num
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                int top = stack.pop();
                map.put(top, num);
            }
            
            stack.push(num);
        }
        
        int[] ans = new int[nums1.length];
        for (int i=0; i<nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        
        return ans;
    }

    private int[] bruteForce(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i=0; i<ans.length; i++) {
            ans[i] = -1;
        }
        
        for (int i=0; i<nums1.length; i++) {
            for (int j=0; j<nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    for (int k=j+1; k<nums2.length; k++) {
                        if (nums2[k] > nums1[i]) {
                            ans[i] = nums2[k];
                            break;
                        }
                    }
                    break;
                }
            }
        }

        return ans;
    }
}
// @lc code=end


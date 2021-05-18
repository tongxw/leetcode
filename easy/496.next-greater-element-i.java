import java.util.HashMap;

/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i=0; i<ans.length; i++) {
            ans[i] = -1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums1.length; i++) {
            map.put(nums1[i], i);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                int top = stack.pop();
                if (map.containsKey(top)) {
                    ans[map.get(top)] = nums2[i];
                }
            }

            stack.push(nums2[i]);
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


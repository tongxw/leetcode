import java.util.Stack;

/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        // for every height[i], the water it can hold should be
        // the min value of left height max and right height max
        int len = height.length;
        if (len == 0) {
            return 0;
        }
        int[] lMax = new int[len];
        int[] rMax = new int[len];

        lMax[0] = height[0];
        for (int i=1; i<len; i++) {
            lMax[i] = Math.max(lMax[i-1], height[i]);
        }

        rMax[len-1] = height[len-1];
        for (int i=len - 2; i>=0; i--) {
            rMax[i] = Math.max(rMax[i+1], height[i]);
        }

        int total = 0;
        for (int i=0; i<len; i++) {
            int water = Math.min(lMax[i], rMax[i]) - height[i];
            if (water > 0) {
                total += water;
            }
        }

        return total;

    }

    private int monostoneStack(int[] height) {
        // monostoneStack
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[height.length];
        for (int i=0; i<height.length; i++) {
            while (!stack.isEmpty() && stack.peek() > height[i]) {
                ret[i] = stack.pop() - height[i];
            }

            stack.push(height[i]);
        }

        int total = 0;
        for (int r : ret) {
            total += r;
        }

        return total;
    }
}
// @lc code=end


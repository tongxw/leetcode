import java.util.Stack;

/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        return monotoneStack2(height);
    }

    private int solution1(int[] height) {
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

    private int monotoneStack(int[] height) {
        // monostoneStack
        if (height == null) return 0;
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, maxWater = 0;
        while (i < height.length){
            if (s.isEmpty()) {
                s.push(i++);
            } else if (height[i] <= height[s.peek()]) {
                s.push(i++);
            } else {
                // next height is higher
                int bottomIndex = s.pop();
                if (s.isEmpty()) {
                    // no left height
                    continue;
                }
                int leftHeightIndex = s.peek();

                // which is lower, left or right?
                int lower = Math.min(height[leftHeightIndex], height[i]);

                // (i-s.peek()-1): calculate the size for all the indexes
                int water = (lower - height[bottomIndex]) * (i - s.peek() - 1);
                maxWater += water;

                // do not increase i, check the next top at the stack
            }
        }
        return maxWater;
    }

    private int monotoneStack2(int[] height) {
        if (height == null) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int maxWater = 0;
        for (int i=0; i<height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int lastHeightIndex = stack.pop();
                if (stack.isEmpty()) {
                    continue;
                } else {
                    int leftToLastHeightIndex = stack.peek();
                    int lower = Math.min(height[leftToLastHeightIndex], height[i]);
                    maxWater += (lower - height[lastHeightIndex]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }

        return maxWater;
    }
}
// @lc code=end


import java.util.Stack;

/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        return monostoneStack(height);
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

    private int monostoneStack(int[] height) {
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
                int bottom = s.pop();
                if (s.isEmpty()) {
                    // no left height
                    continue;
                }
                int leftHeight = s.peek();

                // which is higher, left or right?
                int higher = Math.min(leftHeight, height[i]);
                int water = higher - bottom;
                maxWater += water;

                // do not increase i, check the next top at the stack
            }


            // if (s.isEmpty() || height[i] <= height[s.peek()]){
            //     s.push(i++);
            // } else { // height[i] > height[s.peek()]
            //     int bot = s.pop();
            //     maxBotWater = s.isEmpty()? // empty means no il
            //     0:(Math.min(A[s.peek()],A[i])-A[bot])*(i-s.peek()-1);
            //     maxWater += maxBotWater;
            // }
        }
        return maxWater;
    }
}
// @lc code=end


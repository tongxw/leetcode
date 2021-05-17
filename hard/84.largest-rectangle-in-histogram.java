import java.util.Stack;

/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        return monotoneStack(heights);
    }

    private int bruteForce(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int area = heights[0];
        for (int i=0; i<heights.length; i++) {
            // get the min height from i to len-1
            int height = heights[i];
            for (int j=i; j<heights.length; j++) {
                // calculate all the possible area
                height = Math.min(height, heights[j]);
                area = Math.max(area, height * (j- i + 1));
            }
        }

        return area;
    }

    private int solution2(int[] heights) {
        // for every height[i], find the left most which height[left] >= height[i]
        // and find the right most which height[right] >= height[i]
        // then for this height[i], the rectangle area is (right-left+1) * height[i]
        // and we can get the max(rectangle[0, 1,.... len-1])
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] rectangles = new int[len];

        left[0] = 0;
        right[len-1] = len-1;
        for (int i=0; i<len; i++) {
            // left
            for (int j=i-1; j>=0; j--) {
                if (heights[j] >= heights[i]) {
                    left[i] = j;
                } else {
                    break;
                }
            }

            // right
            for (int j=i+1; j<len; j++) {
                if (heights[j] >= heights[i]) {
                    right[i] = j;
                } else {
                    break;
                }
            }
        }

        int area = heights[0];
        for (int i=0; i<len; i++) {
            area = Math.max(area, heights[i] *(right[i] - left[i] + 1));
        }

        return area;
    }

    private int monotoneStack(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        int i = 0;

        // the left most bar index should be -1
        // and the right most index should be height.lengh
        int leftMostIndex = -1;
        int rightMostIndex = heights.length;
        stack.push(leftMostIndex);
        while (i<heights.length) {
            if (stack.peek() == leftMostIndex) {
                stack.push(i++);
            } else if (heights[i] > heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int lastHeightIndex = stack.pop();
                int lastHeight = heights[lastHeightIndex];
                int leftBarIndex = stack.peek();
                // (i-1) - (leftBarIndex+1) + 1
                area = Math.max(area, lastHeight * (i - leftBarIndex - 1));
            }
        }

        // handle the rest of the bars
        while (stack.peek() != -1) {
            int lastHeightIndex = stack.pop();
            int lastHeight = heights[lastHeightIndex];
            int leftBarIndex = stack.peek();
            area = Math.max(area, lastHeight * (heights.length - leftBarIndex - 1));
        }

        return area;
    }
}
// @lc code=end


import java.util.Stack;

class Solution {
    public int trap(int[] height) {
        return monostoneStack(height);
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
        }
        return maxWater;
    }

    public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}



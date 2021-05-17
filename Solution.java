import java.util.Stack;

class Solution {
    public int trap(int[] height) {
        return monostoneStack(height);
    }

    private int monostoneStack(int[] height) {
        if (height == null) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int[] water = new int[height.length];
        for (int i=0; i<height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int lastHeightIndex = stack.pop();
                if (stack.isEmpty()) {
                    water[lastHeightIndex] = 0;
                    continue;
                } else {
                    int leftToLastHeightIndex = stack.peek();
                    int lower = Math.min(height[leftToLastHeightIndex], height[i]);
                    water[lastHeightIndex] = lower - height[lastHeightIndex];
                }
            }
            stack.push(i);
        }

        int maxWater = 0;
        for (int i=0; i<water.length; i++) {
            maxWater += water[i];
            for (int j=i+1; j<water.length; j++) {
                if (water[j] != 0) {
                    maxWater += water[j];
                } else {
                    break;
                }
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}



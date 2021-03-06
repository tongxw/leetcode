import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int len = temperatures.length;
        int[] ans = new int[len];
        int i=0;
        while(i < len) {
            if (stack.isEmpty() || temperatures[i] <= stack.peek()) {
                stack.push(i++);
            } else {
                // warmer
                int lastDay = stack.pop();
                int days = i - lastDay;
                String strOut = "current i: " + i + " last day: " + lastDay;
                System.out.println(strOut);
                ans[lastDay] = days;
            }

        }

        // handle all days
        while (!stack.isEmpty()) {
            ans[stack.pop()] = 0;
        }
        
        // [75,71,69,72,76,73]
        return ans;
    }

    public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.dailyTemperatures(new int[]{75,71,69,72,76,73}));
    }
}



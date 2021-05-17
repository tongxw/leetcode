import java.util.Stack;

/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int len = temperatures.length;
        int[] ans = new int[len];
        int i=0;
        while(i < len) {
            if (stack.isEmpty() || temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i++);
            } else {
                // warmer
                int lastDay = stack.pop();
                int days = i - lastDay;
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
}
// @lc code=end


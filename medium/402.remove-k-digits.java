import java.util.Stack;

/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }


        // monotone stack, number is from small to big, from bottom to top
        Stack<Integer> stack = new Stack<>();
        char[] nums = num.toCharArray();

        for (int i=0; i<nums.length; i++) {
            int cur = nums[i] - '0';
            while (!stack.isEmpty() && cur < stack.peek() && k > 0) {
                k--;
                stack.pop();
            }

            if (cur != 0 || !stack.isEmpty()) {
                // cur == 0 && stack.isEmpty(), do not push 0 to the stack
                stack.push(cur);
            }
        }

        while (k > 0 && !stack.isEmpty()) {
            k--;
            stack.pop();
        }

        StringBuffer buffer = new StringBuffer();
        while (!stack.isEmpty()) {
            buffer.insert(0, stack.pop());
        }

        // "10200"\n1
        // "10"\n1
        // String ret = buffer.toString().replaceAll("^0+", "");
        String ret = buffer.toString();
        return ret.isEmpty() ? "0" : ret;
    }
}
// @lc code=end


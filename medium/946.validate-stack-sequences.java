import java.util.Stack;

/*
 * @lc app=leetcode id=946 lang=java
 *
 * [946] Validate Stack Sequences
 */

// @lc code=start
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pushIdx = 0;
        int popIndex = 0;
        for (; pushIdx<pushed.length; pushIdx++) {
            stack.push(pushed[pushIdx]);
            // if pushed one is the next one to be popped, pop it now, or it won't be able to be popped
            if (pushed[pushIdx] == popped[popIndex]) {
                stack.pop();
                popIndex++;
                while (!stack.isEmpty()) {
                    // before pushing more data, check if the top of the stack is the next one to be popped
                    if (stack.peek() == popped[popIndex]) {
                        stack.pop();
                        popIndex++;
                    } else {
                        break;
                    }
                }
            }
        }

        // if valid, all data should be popped
        return stack.isEmpty();
    }
}
// @lc code=end


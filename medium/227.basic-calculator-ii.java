import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 * [array][stack]
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        // since the "* \" have higher priority than "+ -"
        // we need to use a stack to track all the number in s
        // stack operation is based on the op sign pre to the number,
        // if it is "+", push num to stack
        // if it is "-", push -num to stack
        // if it is "*" or "/", pop the stack and do the calculation
        // then push the result to stack
        // after finish the iteration, calculate everything in the stack.
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int num = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            // System.out.println(c);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else {
                calc(preSign, num, stack);
                preSign = c;
                num = 0;
            }
        }

        // need to calculate the last number!!!
        calc(preSign, num, stack);

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    private void calc(char preSign, int num, Deque<Integer> stack) {
        if (preSign == '+') {
            stack.push(num);
        } else if (preSign == '-') {
            stack.push(-num);
        } else if (preSign == '*') {
            // System.out.println(stack.peek() + " * " + num);
            stack.push(stack.pop() * num);
        } else {
            stack.push(stack.pop() / num);
        }
    }
}
// @lc code=end


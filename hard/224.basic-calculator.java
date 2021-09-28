import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 * [array][stack]
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        // when iterate the chars in s, calculate the total based on '+' or '-'
        // if we meet '(', we need to push the current total and sign to the stack
        // and when we find ')', we will pop up the stack latest value and sign
        // and add it to the total
        // the sign can be +1 or -1
        s = s.replaceAll(" ", "");
        int sign = 1;
        int num = 0;
        int total = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else {
                if (c == '+') {
                    total += sign * num;
                    sign = 1;
                } else if (c == '-') {
                    total += sign * num;
                    sign = -1;
                } else if (c == '(') {
                    stack.push(sign);
                    stack.push(total);
                    total = 0;
                    sign = 1;
                } else if (c == ')') {
                    total += sign * num; // last number!!!
                    int lastTotal = stack.pop();
                    int lastSign = stack.pop();
                    total = lastTotal + lastSign * total;
                }
                num = 0;
            }
        }

        total += sign * num; // last number;
        return total;
    }
}
// @lc code=end


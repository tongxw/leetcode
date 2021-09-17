import java.util.Stack;

/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        return dfs(chars, 0)[0];
    }

    private String stackSolution(char[] chars) {
        Stack<String> stack = new Stack<>();
        String number = "";
        
        for (char c: chars) {
            if (c >= '0' && c<= '9') {
                number += c;
            } else if (c == '[') {
                if (!"".equals(number)) {
                    stack.push(number);
                    number = "";
                }
                stack.push(String.valueOf(c));
            } else if (c == ']') {
                // pop
                String topStr;
                StringBuffer buffer = new StringBuffer();
                while (!"[".equals(topStr = stack.pop())) {
                    buffer.insert(0, topStr);
                }
 
                String tmp = buffer.toString();
                int repeat = Integer.parseInt(stack.pop()) - 1;
                while (repeat != 0) {
                    buffer.append(tmp);
                    repeat--;
                }
                stack.push(buffer.toString());
            } else {
                // 'a' - 'z'
                stack.push(String.valueOf(c));
            }
        }

        StringBuffer res = new StringBuffer();
        while (stack.size() != 0) {
            res.insert(0, stack.pop());
        }

        // ""100[leetcode]""
        // ""3[2[a]]""
        // ""30[22[a]]""
        // ""3[b3[a]]""
        return res.toString();
    }

    private String[] dfs(char[] chars, int start) {
        StringBuilder res = new StringBuilder();
        int repeat = 0;
        for (int i=start; i<chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                repeat = repeat * 10 + (c - '0');
            } else if (c == '[') {
                // calculate the result inside '[]''
                String[] ret = dfs(chars, i + 1);
                i = Integer.parseInt(ret[1]);
                while (repeat > 0) {
                    res.append(ret[0]);
                    repeat--;
                }
            } else if (c == ']') {
                // return the string inside '[]', also the current index
                return new String[] {res.toString(), String.valueOf(i)};
            } else {
                // chars
                res.append(c);
            }
        }

        return new String[]{ res.toString(), String.valueOf(chars.length) };
    }
}
// @lc code=end


import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/*
 * @lc app=leetcode id=316 lang=java
 *
 * [316] Remove Duplicate Letters
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int[] alphabet = new int[26];

        // count letters in the string
        for (char c : chars) {
            alphabet[c - 'a']++;
        }

        // if chars[i + 1] < chars[i], and chars[i] has more than one count in this string,
        // we need to remove chars[i].
        // use monotone stack
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> set = new HashSet<>(); // check if the char already exists in the stack
        int i = 0;
        while (i < chars.length) {
            int c = chars[i] - 'a';
            if (set.contains(c)) {
                // skip if exists
                alphabet[c]--;
                i++;
                continue;
            }

            if (stack.isEmpty() || chars[stack.peek()] < chars[i]) {
                stack.push(i);
                set.add(c);
                i++;
            } else {
                // before pop stack, we need to make sure there is at least one letter
                int top = chars[stack.peek()] - 'a';
                if (alphabet[top] <= 1) {
                    // can't pop, push the current one if it does not exist in the stack
                    stack.push(i);
                    set.add(c);
                    i++;
                } else {
                    set.remove(chars[stack.pop()] - 'a');
                    alphabet[top]--;
                }
            }
        }

        StringBuffer buffer = new StringBuffer();
        while(!stack.isEmpty()) {
            buffer.insert(0, chars[stack.pop()]);
        }

        // ""cbacdcbc""
        // ""ecbacba""
        // ""abacb""
        // ""bbcaac""
        return buffer.toString();
    }
}
// @lc code=end


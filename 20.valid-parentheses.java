import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        ArrayList<String> stack = new ArrayList<String>();
        HashMap<String, String> brackets = new HashMap<String, String>() {
            {
                put("(", ")");
                put("{", "}");
                put("[", "]");
            }
        };

        for (int i=0; i<s.length(); i++) {
            String cur = String.valueOf(s.charAt(i));
            if (brackets.containsKey(cur)) {
                stack.add(cur);
            } else {
                int size = stack.size();
                if (size == 0) {
                    return false;
                }
                String peak = stack.get(size - 1);
                stack.remove(size - 1);
                if (!cur.equals(brackets.get(peak))) {
                    return false;
                }
            }
   
        }

        return stack.size() == 0;
    }

    public static void main(String []args) {
        Solution s = new Solution();
        s.isValid("()");

    }
}
// @lc code=end


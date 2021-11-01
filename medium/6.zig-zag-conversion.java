/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        // simulation
        List<StringBuilder> rows = new ArrayList<>();
        for (int i=0; i<Math.min(s.length(), numRows); i++) {
            rows.add(new StringBuilder());
        }
        
        boolean down = false;
        int curRow = 0;
        for (int i=0; i<s.length(); i++) {
            rows.get(curRow).append(s.charAt(i));
            if (curRow == 0 || curRow == rows.size() - 1) {
                down = !down;
            }
            
            if (down) {
                curRow++;
            } else {
                curRow--;
            }
        }
        
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        
        return ret.toString();
    }
}
// @lc code=end


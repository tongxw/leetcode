/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        
        int left = 0;
        int right = n - 1;
        
        
        // trim leading
        while (left < n && chars[left] == ' ') {
            left++;
        }
        
        // trim trailing
        while (right > 0 && chars[right] == ' ') {
            right--;
        }
        
        // read and write pointers to trim the extra spaces in the middle
        int write = left;
        boolean foundSpace = false;
        for (int read = left; read <= right; read++) {
            if (chars[read] == ' ') {
                if (!foundSpace) {
                    // first space, can write
                    chars[write++] = chars[read];
                }
                foundSpace = true;
            } else {
                // not a space, can write
                foundSpace = false;
                chars[write++] = chars[read];
            }
        }
        
        right = write - 1;
        
        reverse(chars, left, right);
        
        int l = left;
        int r = left;
        for (; r<=right; r++) {
            if (chars[r] == ' ') {
                reverse(chars, l, r - 1);
                l = r + 1;
            }
        }
        
        reverse(chars, l, r - 1);
        
        return String.valueOf(chars).substring(left, right + 1);
    }
    
    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end]= temp;
            start++;
            end--;
        }
    }
}
// @lc code=end


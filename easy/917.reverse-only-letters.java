/*
 * @lc app=leetcode id=917 lang=java
 *
 * [917] Reverse Only Letters
 * [2pointers]
 */

// @lc code=start
class Solution {
    public String reverseOnlyLetters(String s) {
        int front = 0;
        int back = s.length() - 1;
        char[] allChars = s.toCharArray();
        while (front < back) {
            if (!Character.isLetter(allChars[front])) {
                front++;
                continue;
            }

            if (!Character.isLetter(allChars[back])) {
                back--;
                continue;
            }

            // System.out.println("chars front: " + front + " back: " + back);
            char temp = allChars[front];
            allChars[front] = allChars[back];
            allChars[back] = temp;
            front++;
            back--;
        }
        
        return new String(allChars);
    }
}
// @lc code=end


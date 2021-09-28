/*
 * @lc app=leetcode id=1629 lang=java
 *
 * [1629] Slowest Key
 * [array]
 */

// @lc code=start
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] keys = keysPressed.toCharArray();
        char ans = keys[0];
        int maxTime = releaseTimes[0];
        for (int i=1; i<keys.length; i++) {
            int time = releaseTimes[i] - releaseTimes[i-1];
            if (time > maxTime) {
                //System.out.println("time: " + time + " key: " + keys[i]);
                maxTime = time;
                ans = keys[i];
            } else if (time == maxTime && ans < keys[i]) {
                //System.out.println("same time: " + time + " key: " + keys[i] + "ans: " + ans);
                ans = keys[i];
            }
        }

        // [28,65,97]\n"gaf"
        return ans;
    }
}
// @lc code=end


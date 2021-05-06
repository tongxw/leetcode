import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=401 lang=java
 *
 * [401] Binary Watch
 */

// @lc code=start
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ret = new ArrayList<String>();
        for (int h=0; h<12; h++) {
            for (int m=0; m<60; m++) {
                // hour to move 6 bit left
                if (Integer.bitCount((h<<6) + m) == turnedOn) {
                    ret.add(String.format("%d:%02d", h, m));
                }
            }
        }

        return ret;

        // HashMap<Integer, String[]> map = new HashMap<Integer, String[]>() {
        //     {
        //         put(0, new String[]{"0"});  
        //         put(1, new String[]{"1", "2", "4", "8"});  
        //         put(2, new String[]{"3", "5", "9", "6", "10"});
        //         put(3, new String[]{"7", "11"});  
        //     }
        // };
        // int[] minute = {1, 2, 4, 8, 16, 32};

        // // get the possible cartesian product for hour x minute
        // ArrayList<String> ret = new ArrayList<String>();
        // for (int i=0; i<=turnedOn; i++) {
        //     ArrayList<String> hourStrs = getPossibleNumber(hour, i, 12);
        //     ArrayList<String> minuteStrs = getPossibleNumber(minute, turnedOn-i, 60);
        //     for (String hourStr: hourStrs) {
        //         for (String minuteStr: minuteStrs) {
        //             ret.add(hourStr + ":" + minuteStrs);
        //         }
        //     }
        // }

        // return ret;
    }

    // private ArrayList<String> getPossibleNumber(int[] nums, int count, int max) {
    //     ArrayList<String> ret = new ArrayList<String>();
    //     for ()


    //     return ret;
    // }

}
// @lc code=end


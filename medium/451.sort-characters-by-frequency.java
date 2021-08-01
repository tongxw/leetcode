import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 */

// @lc code=start
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pQ = new PriorityQueue<>((c1, c2) -> {
            return countMap.get(c2) - countMap.get(c1);
        });
        
        for (char c : countMap.keySet()) {
            pQ.offer(c);
        }

        StringBuffer buffer = new StringBuffer();
        while (!pQ.isEmpty()) {
            char c = pQ.poll();
            for (int i=0; i<countMap.get(c); i++) {
                buffer.append(c);
            }
        }

        return buffer.toString();
    }
}
// @lc code=end


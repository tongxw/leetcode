import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // return hashmapSolution(words, k);
        return maxHeapSolution(words, k);
    }

    private List<String> hashmapSolution(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        String[] ans = map.keySet().toArray(new String[0]);
        Arrays.sort(ans, (String str1, String str2) -> {
            return map.get(str1) == map.get(str2) ? str1.compareTo(str2) : map.get(str2) - map.get(str1);
        });

        List<String> ret = new ArrayList<String>();
        Collections.addAll(ret, Arrays.copyOf(ans, k));

        return ret;
    }

    private List<String> maxHeapSolution(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int len = map.keySet().size();
        PriorityQueue<String> maxHeap = new PriorityQueue<>(len, (str1, str2) -> {
            return map.get(str1) == map.get(str2) ? str1.compareTo(str2) : map.get(str2) - map.get(str1);
        });

        for (String word : map.keySet()) {
            maxHeap.add(word); // O(logN)
        }

        List<String> ret = new ArrayList<String>();
        while (k > 0) {
            ret.add(maxHeap.poll());
            k--;
        }

        return ret;
    }
}
// @lc code=end


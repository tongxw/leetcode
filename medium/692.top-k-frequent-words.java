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

        List<String> ret = new ArrayList<String>();
        int len = map.keySet().size();

        PriorityQueue<String> maxHeap = new PriorityQueue<>(len, (str1, str2) -> {
            return map.get(str1) == map.get(str2) ? str1.compareTo(str2) : map.get(str2) - map.get(str1);
        });

        //note!!!: Your answer should be sorted by frequency from highest to lowest
        // for (String word : map.keySet()) {
        //     if (maxHeap.size() < len) {
        //         // System.out.println("not full: " + word);
        //         maxHeap.offer(word); // O(logN)
        //     } else {
        //         String topWord = maxHeap.peek();
        //         if (map.get(topWord) > map.get(word) || (map.get(topWord) == map.get(word) && topWord.compareTo(word) < 0)) {

        //             // System.out.println("full:" + topWord);
        //             ret.add(maxHeap.poll());
        //             maxHeap.offer(word);
        //         } else {
        //             // System.out.println("full, just add:" + word);
        //             ret.add(word);
        //         }
        //     }
        // }

        for (String word : map.keySet()) {
            maxHeap.offer(word);
        }


        // List<String> ret = new ArrayList<String>();
        while (k > 0) {
            ret.add(maxHeap.poll());
            k--;
        }

        //["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"]\n4
        //["i", "love", "leetcode", "i", "love", "coding"]\n3
        return ret;
    }
}
// @lc code=end


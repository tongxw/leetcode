import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 * [array][hashmap][heap]
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // return heapSolution(nums, k);
        return bucketSort(nums, k);
    }

    private int[] quickSort(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Integer[] allNums = map.keySet().toArray(new Integer[0]);
        Arrays.sort(allNums, (num1, num2) -> {
            return map.get(num2) - map.get(num1);
        });
        
        int[] ans = new int[k];
        for (int i=0; i<k; i++) {
            ans[i] = allNums[i];
        }

        return ans;
    }

    private int[] heapSolution(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            System.out.println("len=1: " + num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[k];
        int len = map.keySet().size() - k;
        int i = 0;
        if (len == 0) {
            for (int num : map.keySet()) {

                ans[i++] = num;
            }

            return ans;
        }
        PriorityQueue<Integer> pQ = new PriorityQueue<>(len, (num1, num2) -> {
            return map.get(num2) - map.get(num1);
        });

        for (int num : map.keySet()) {
            if (pQ.size() >= len) {
                // System.out.println("peak: " + pQ.peek());
                // System.out.println("num: " + num);
                if (map.get(pQ.peek()) > map.get(num)) {
                    ans[i++] = pQ.poll();
                    pQ.offer(num);
                } else {
                    ans[i++] = num;
                }
            } else {
                pQ.offer(num);
            }
        }

        // while (!pQ.isEmpty()) {
        //     System.out.println(pQ.poll());
        // }
        
        return ans;
    }

    private int[] bucketSort(int[] nums, int k) {
        // time O(n), space O(n)
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            List<Integer> bucket = buckets[count];
            if (bucket == null) {
                bucket = new ArrayList<>();
                buckets[count] = bucket;
            }
            bucket.add(num);
        }

        int[] ret = new int[k];
        int j = 0;
        for (int i=buckets.length - 1; i>=0; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    ret[j++] = num;
                    if (j == k) {
                        return ret;
                    }
                }
            }
        }

        return ret;
    }

}
// @lc code=end


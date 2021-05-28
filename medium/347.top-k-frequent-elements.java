/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int num : nums) {
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }

        // Integer[] allNums = map.keySet().toArray(new Integer[0]);
        // Arrays.sort(allNums, (num1, num2) -> {
        //     return map.get(num2) - map.get(num1);
        // });
        
        // int[] ans = new int[k];
        // for (int i=0; i<k; i++) {
        //     ans[i] = allNums[i];
        // }

        // return ans;

        return heapSolution(nums, k);
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
                // System.out.println("len=0: " + num);
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

}
// @lc code=end


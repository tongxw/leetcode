import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=697 lang=java
 *
 * [697] Degree of an Array
 */

// @lc code=start
class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> countMap = new HashMap<>(); //{num : {count, 1st idx, last idx}}
        for (int i=0; i<nums.length; i++) {
            if (countMap.containsKey(nums[i])) {
                int[] numCount = countMap.get(nums[i]);
                numCount[0] += 1;
                numCount[2] = i;
            } else {
                int[] numCount = new int[3];
                numCount[0] = 1;
                numCount[1] = i;
                countMap.put(nums[i], numCount);
            }
        }

        int ans = nums.length;
        int degree = 0;
        for (Map.Entry<Integer, int[]> entry : countMap.entrySet()) {
            int[] numCount = entry.getValue();
            if (degree < numCount[0]) {
                degree = numCount[0];
                ans = numCount[2] - numCount[1] + 1;
            } else if (degree == numCount[0]) {
                ans = Math.min(ans, numCount[2] - numCount[1] + 1);
            } else {
                // do nothing, this is not the degree length
            }
        }

        return ans;
    }

    public int solution1(int[] nums) {
        int degree = 0;
        int ans = nums.length;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int count = countMap.getOrDefault(nums[i], 0) + 1;
            degree = Math.max(degree, count);
            countMap.put(nums[i], count);
        }

        countMap.clear();
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int count = countMap.getOrDefault(nums[i], 0) + 1;
            countMap.put(nums[i], count);

            int j = 0;
            if (!indexMap.containsKey(nums[i])) {
                indexMap.put(nums[i], i);
            } else {
                j = indexMap.get(nums[i]);
            }
            if (count == degree) {
                ans = Math.min(ans, i - j + 1);
            }
        }

        return ans;
    }
}
// @lc code=end


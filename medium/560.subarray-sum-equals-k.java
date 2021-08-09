import java.util.HashMap;

/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        // sum(l...r) = pre[r] - pre[l-1] = k
        // first, get get preSums
        // then it is a two-sum question

        // int[] preSums = new int[nums.length];
        // preSums[0] = nums[0];
        // for (int i=1; i<nums.length; i++) {
        //     preSums[i] += preSums[i-1] + nums[i];
        // }

        int[] preSums = new int[nums.length + 1];
        // preSums[0] = nums[0];
        for (int i=0; i<nums.length; i++) {
            preSums[i+1] += preSums[i] + nums[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        // KEY! map contains preSums as key. 
        // 关于mp.put(0, 1); 这一行的作用就是为了应对 nums[0] +nums[1] + ... + nums[i] == k 的情况的,
        // 也就是从下标 0 累加到下标 i, 举个例子说明, 如数组 [1, 2, 3, 6], 
        // 那么这个数组的累加和数组为 [1, 3, 6, 12] 
        // 如果 k = 6, 假如map中没有预先 put 一个 (0, 1) ,
        // 如果此时我们来到了累加和为 6 的位置, 这时map中的情况是 (1, 1), (3, 1),
        // 而 mp.containsKey(pre - k) , 这时 pre - k 也就是 6 - 6 = 0, 
        // 因为 map 中没有 (0, 1) 所以 count 的值没有加一, 其实这个时候我们就是忽略了从下标 0 
        // 累加到下标 i 等于 k 的情况, 我们仅仅是统计了从下标大于 0 到某个位置等于 k 的所有答案,
        // map.put(0, 1);

        // 如果前缀和preSum[0]是子数组为空是preSum = 0，就是比原数组多了一位
        // 那么就不用初始化mp.put(0, 1)

        int ans = 0;
        for (int pre : preSums) {
            if (map.containsKey(pre - k)) {
                ans += map.get(pre - k);
            }

            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return ans;
    }
}
// @lc code=end


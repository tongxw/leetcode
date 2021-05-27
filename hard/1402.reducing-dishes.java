import java.util.Arrays;

/*
 * @lc app=leetcode id=1402 lang=java
 *
 * [1402] Reducing Dishes
 */

// @lc code=start
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        /*
         * 将所有菜的满意程度从大到小排序
         * 我们按照排好序的顺序依次遍历这些菜，如果
         * s(0) + s(1) +...+ s(i) > 0, 那么第i道菜可以选择。否则直接退出循环
         *
         */
        Arrays.sort(satisfaction);
        int preSum = 0;
        int count = -1;
        int ans = 0;
        for (int i=satisfaction.length - 1; i>=0; i--) {
            if (preSum + satisfaction[i] > 0) {
                preSum += satisfaction[i];
                // count = i;
                ans += preSum;
            } else {
                break;
            }
        }

        // if (count != -1) {
        //     int times = 1;
        //     for (int i = count; i<satisfaction.length; i++) {
        //         ans += satisfaction[i] * times;
        //         times++;
        //     }
        // }

        return ans;
    }
}
// @lc code=end


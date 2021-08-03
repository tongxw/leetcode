import java.util.HashMap;

/*
 * @lc app=leetcode id=1072 lang=java
 *
 * [1072] Flip Columns For Maximum Number of Equal Rows
 */

// @lc code=start
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        //https://leetcode-cn.com/problems/flip-columns-for-maximum-number-of-equal-rows/solution/1072-an-lie-fan-zhuan-de-dao-zui-da-zhi-deng-xing-/
        // 如果某两行可以通过这个规则达成一致，要么它们全等，要么它们全反。
        // 如何将全反的行，转换为全等的行：
        //  针对每一行，如果第一位是0，不做变化。如果第一位是1，对这一行求异或。
        // 最后统计最多的相同行数
        HashMap<String, Integer> counter = new HashMap<>();
        for (int[] row : matrix) {
            StringBuilder build = new StringBuilder();
            if (row[0] == 0) {
                for (int num : row) {
                    build.append(num);
                }
            } else {
                for (int num : row) {
                    build.append(num ^ 1);
                }
            }

            String str = build.toString();
            counter.put(str, counter.getOrDefault(str, 0) + 1);
        }

        int ans = 0;
        for (int count : counter.values()) {
            ans = Math.max(ans, count);
        }

        return ans;
    }
}
// @lc code=end


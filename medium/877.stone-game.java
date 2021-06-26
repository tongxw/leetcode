/*
 * @lc app=leetcode id=877 lang=java
 *
 * [877] Stone Game
 */

// @lc code=start
class Solution {
    private int alex = 0;
    private int lee = 0;
    public boolean stoneGame(int[] piles) {
        // https://leetcode-cn.com/problems/stone-game/solution/shi-zi-you-xi-by-leetcode-solution/

        // dp[i][j] 表示当剩下的石子堆为下标i到下标j时，即在下标范围 [i, j]中，当前玩家与另一个玩家的石子数量之差的最大值，
        // 注意当前玩家不一定是先手Alex。
        // i > j => dp[i][j] = 0
        // i = j => dp[i][j] = piles[i] 仅剩一堆石头

        // 如果dp[i][j]是玩家A和B的差值，即A-B，此时轮到A取石头，取piles[i]或者piles[j]
        // 那么dp[i+1][j] 和 dp[i][j-1]就是B和A的差值，即B-A
        // 现在要求A-B是最大的，即，
        // i < j => dp[i][j] = max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1])

        // 如果最后dp[0][piles.length−1] > 0 则赢得比赛

        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i=0; i<n; i++) {
            dp[i][i] = piles[i];
        }

        for (int i=n-2; i>=0; i--) {
            for (int j=i+1; j<n; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1]);
            }
        }

        return dp[0][n-1] > 0;

    }

    public boolean gamingTheory(int[] piles) {
        // 由于piles.lengh为偶数
        // 对piles编号，假设[1,2,3,4,5,6] 一共6堆石头
        // 先手Alex可以选择奇数序列(1 3 5)或者偶数序列(2 4 6)
        // 后手Lee只能选择奇数序列或者偶数序列，取决于先手Alex的选择
        // 所以Alex可以先计算奇数序列的石头总数和偶数序列的石头总数，总是选最大的，必胜
        return true;
    }


}
// @lc code=end


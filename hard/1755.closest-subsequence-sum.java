import java.util.Arrays;

/*
 * @lc app=leetcode id=1755 lang=java
 *
 * [1755] Closest Subsequence Sum
 */

// @lc code=start
class Solution {
    // TODO
    // https://leetcode-cn.com/problems/closest-subsequence-sum/solution/zhuang-ya-dp-zhi-cong-kan-shu-ju-fan-wei-kve3/
    public int minAbsDifference(int[] nums, int goal) {
        // 看到nums.length <= 40，可以直接枚举所有子数组并求和，TC 2^40
        // 但是2^40就超时了，所以想到把子数组两等分，这样变成2^20就可以了
        int n = nums.length;
        int l = n / 2;
        int r = n - l;

        // 类似前缀和思想，枚举出来的子集索引是用位运算表示的，所以索引为i的子集和 sums[i] = sums[i - (1<<j)] + nums[j]
        // 其中sum[0] = 0 表示空子集
        int lSubSetSize = 1 << l;
        int[] lSums = new int[lSubSetSize];
        for (int i=1; i<lSubSetSize; i++) {
            for (int j=0; j<l; j++) {
                if ((i & (1 << j)) == 0) {
                    // 此时Integer.toBinaryString(i)表示的子集，并不包含nums[j]，所以跳过
                    continue;
                }
                lSums[i] = lSums[i - (1<<j)] + nums[j];
            }
        }

        int rSubSetSize = 1 << r;
        int[] rSums = new int[rSubSetSize];
        for (int i=1; i<rSubSetSize; i++) {
            for (int j=0; j<r; j++) {
                if ((i & (1 << j)) == 0) {
                    continue;
                }
                rSums[i] = rSums[i - (1<<j)] + nums[l+j]; //注意这里是右半数组
            }
        }

        // 遍历左右半边子集和，找最接近goal的值
        int ret = Integer.MAX_VALUE;
        for (int x: lSums) {
            ret = Math.min(ret, Math.abs(goal - x));
        }
        for (int x: rSums) {
            ret = Math.min(ret, Math.abs(goal - x));
        }

        // 从左右半边子集和中各选一个数字，要求lSums[x] + rSums[y]尽量接近goal
        // 先排序，然后双指针夹逼
        Arrays.sort(lSums);
        Arrays.sort(rSums);
        
        int i = 0; // 左侧最小
        int j = rSums.length - 1; // 右侧最大
        while (i < lSums.length && j >= 0) {
            int sum = lSums[i] + rSums[j];
            ret = Math.min(ret, Math.abs(goal - sum));
            if (sum > goal) {
                j--;
            } else {
                i++;
            }
        }
        
        return ret;
    }
        // Arrays.sort(nums);
        // int[] sums = new int[nums.length + 1];
        // sums[0] = 0;
        // for (int i=0; i<sums.length - 1; i++) {
        //     sums[i + 1] = nums[i] + sums[i];
        // }


        // int sum = 0;
        // int l = 0;
        // for (int r=0; r<nums.length; r++) {
        //     sum += nums[r];
        //     int diff = sum - goal;
        //     if (diff == 0) {
        //         return 0;
        //     } else if (diff < 0)
        // }
}
// @lc code=end


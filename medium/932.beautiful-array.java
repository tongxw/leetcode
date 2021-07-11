import java.util.HashMap;

/*
 * @lc app=leetcode id=932 lang=java
 *
 * [932] Beautiful Array
 */

// @lc code=start
class Solution {
    // 由数字的奇偶特性，可知：奇数 + 偶数 = 奇数 。
    // 因此如果要使得：对于每个  i < j，都不存在  k 满足  i < k < j  使得  A[k] * 2 = A[i] + A[j] 成立，
    // 我们可以令 A[i] 和 A[j] 一个为奇数，另一个为偶数即可。

    // 另外还有两个非常重要的性质，也是本题的突破口。那就是：
    // 性质 1： 如果数组 A 是 漂亮数组，那么将 A 中的每一个数 x 进行 kx + b 的映射，其仍然为漂亮数组。
    //         其中 k 为不等于 0 的整数， b 为整数。
    // 性质 2：如果数组 A 和 B 分别是不同奇偶性的漂亮数组，那么将 A 和 B 拼接起来仍为漂亮数组。

    // 假设长度为 N / 2 和 N - N/2 的漂亮数组被计算出来了。
    // 那么我们只需要对长度为 N/2 的漂亮数组通过性质 1 变换成全部为偶数的漂亮数组，
    // 并将长度为 N - N/2 的漂亮数组也通过性质 1 变换成全部为奇数的漂亮数组。
    // 接下来利用性质 2 将其进行拼接即可得到一个漂亮数组。

    // 刚才我们假设长度为 N / 2 和 N - N/2 的漂亮数组被计算出来了，实际上我们并没有计算出来，
    // 那么其实可以用同样的方法来计算。其实就是分治，将问题规模缩小了，问题本质不变。
    // 递归的终点自然是 N == 1，此时可直接返回 [1]。
    public int[] beautifulArray(int n) {
        HashMap<Integer, int[]> memo = new HashMap<>();
        return divide(n, memo);
    }

    private int[] divide(int n, HashMap<Integer, int[]> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int[] ans = new int[n];
        if (n == 1) {
            ans[0] = 1;
        } else {
            int i = 0;
            for (int x : divide(n - n/2, memo)) {
                ans[i++] = 2 * x - 1;
            }
            for (int x : divide(n / 2, memo)) {
                ans[i++] = 2 * x;
            }
        }


        memo.put(n, ans);
        return ans;
    }
}
// @lc code=end


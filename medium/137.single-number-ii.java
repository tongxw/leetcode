/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        // https://leetcode-cn.com/problems/single-number-ii/solution/zhi-chu-xian-yi-ci-de-shu-zi-ii-by-leetc-23t6/
        // 按32位二进制位，针对每一位，把所有数字相加
        // 如果某一位除3余数是1，这说明单数字的那一位就是1
        // 最后把32位二进制拼起来还原为那个单个的数字

        // 需要注意的是，如果使用的语言对「有符号整数类型」和「无符号整数类型」没有区分，那么可能会得到错误的答案。
        // 这是因为「有符号整数类型」（int 类型）的第31个二进制位（即最高位）是补码意义下的符号位，对应着 -2^{31}
        // 而「无符号整数类型」由于没有符号，第 31 个二进制位对应着 2^{31}
        // 因此在某些语言（例如 Python）中需要对最高位进行特殊判断。
        int ans = 0;
        for (int i=0; i<32; i++) {
            int total = 0;
            for (int num : nums) {
                total += (num >> i) & 1;
            }

            int mod = total % 3;
            if (mod == 1) {
                ans |= (1 << i);
            }
        }

        return ans;
    }
}
// @lc code=end


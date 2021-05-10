// ### 思路

// while num[i]存在 或者 k不为0:
//     当前位sum = 进位 + nums[i](如果存在) + k mod 10 (如果k不为0)；
//     倒序遍历num，同时k = k /10;
//     进位 carry = sum / 10;
//     当前位 digit = sum mod 10;
//     输出数组记录digit;
// 如果最后一位有进位，添加到输出数组中;
// 倒序返回输出数组；


// ### 代码
/*
 * @lc app=leetcode id=989 lang=java
 *
 * [989] Add to Array-Form of Integer
 */

// @lc code=start
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int i = num.length - 1;
        int carry = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (i>=0 || k != 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num[i];
                i--;
            }
            if (k != 0) {
                sum += k % 10;
                k /= 10;
            }

            carry = sum / 10;
            res.add(sum % 10);
        }

        if (carry > 0) {
            res.add(carry);
        }

        Collections.reverse(res);
        return res;
    }
}
// @lc code=end

// **复杂度分析**
// - 时间复杂度：O(N)，其中 N 为数组长度。
// - 空间复杂度：O(N)，其中 N 为数组长度。

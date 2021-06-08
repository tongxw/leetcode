import java.util.HashMap;

/*
 * @lc app=leetcode id=1371 lang=java
 *
 * [1371] Find the Longest Substring Containing Vowels in Even Counts
 */

// @lc code=start
class Solution {
    public int findTheLongestSubstring(String s) {

        // return bruteForce(s);
        // return preSum(s);
        return preSum2(s);
    }

    // TODO review
    private int preSum2(String s) {
        char[] chars = s.toCharArray();

        // 将 5个元音字母出现次数的奇偶视为一种状态，一共有32种状态，不妨使用一个整数代表状态：
        // 第0位为1表示a出现奇数次，第1位为1表示e出现奇数次……以此类推。仅有状态0符合题意。
        int[] vowStatusMap = new int[32];
        Arrays.fill(vowStatusMap, -1);

        //需要注意状态0 首次出现的位置应该设定为 -1
        vowStatusMap[0] = -1;
        int curStatus = 0;
        int ans = 0;

        // 而如果子串 [0，i] 与字串 [0,j] 状态相同，那么字串 [i+1,j] 的状态一定是0
        // 因此可以记录每个状态第一次出现的位置，此后再出现该状态时相减即可
        for (int i=0; i<chars.length; i++) {
            char c = chars[i];
            switch (c) {
                // 在计算状态的时候可以利用异或运算
                case 'a': curStatus ^= 1; break;
                case 'e': curStatus ^= 2; break;
                case 'i': curStatus ^= 4; break;
                case 'o': curStatus ^= 8; break;
                case 'u': curStatus ^= 16; break;
                default: break;
            }
            if (curStatus == 0) {
                ans = Math.max(ans, i+1);
            } else if (vowStatusMap[curStatus] == -1) {
                vowStatusMap[curStatus] = i;
            } else {
                ans = Math.max(ans, i - vowStatusMap[curStatus]);
            }
        }

        return ans;
    }

    // time O(n2)
    private int preSum(String s) {
        char[] chars = s.toCharArray();
        int[][] preSumArrs = new int[chars.length][5];
        int ans = 0;

        int index = getIndex(chars[0]);
        if (index != -1) {
            preSumArrs[0][index]++;
        }

        // calculate how many vowels in all [0...i] sub arrays
        for (int i=1; i<chars.length; i++) {
            int k = getIndex(chars[i]);
            for (int j=0; j<5; j++) {
                preSumArrs[i][j] = preSumArrs[i-1][j];
            }
            if (k != -1) {
                preSumArrs[i][k] += 1;
            }
        }

        // from right to left
        for (int i=chars.length-1; i>=0; i--) {
            // from left to right
            for (int j=0; j<chars.length - i; j++) {
                if (isValid(preSumArrs, chars, j, i+j)) {
                    return i + 1;
                }
            }
        }

        return 0;
    }

    private boolean isValid(int[][] preSumArrs, char[] chars, int left, int right) {
        int index = getIndex(chars[left]);
        // check all the vowes in [i, j]
        for (int i=0; i<5; i++) {
            int preSumLtoR = preSumArrs[right][i] - preSumArrs[left][i];
            preSumLtoR += (index == i ? 1 : 0);
            if ((preSumLtoR & 1) == 1) {
                // odd
                return false;
            }
        }

        return true;
    }

    private int getIndex(char c) {
        if (c == 'a') {
            return 0;
        } else if (c == 'e') {
            return 1;
        } else if (c == 'i') {
            return 2;
        } else if (c == 'o') {
            return 3;
        } else if (c == 'u') {
            return 4;
        } else {
            // not a vowel
            return -1;
        }
    }


    private int bruteForce(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i=0; i<chars.length; i++) {
            int[] counts = new int[26];
            for (int j=i; j<chars.length; j++) {
                char c = chars[j];
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    counts[c - 'a']++;
                }

                if (checkVowels(counts)) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    private boolean checkVowels(int[] counts) {
        return (counts['a' - 'a'] & 1) == 0 && (counts['e' - 'a'] & 1) == 0 &&
            (counts['i' - 'a'] & 1) == 0 && (counts['o' - 'a'] & 1) == 0 &&
            (counts['u' - 'a'] & 1) == 0;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=282 lang=java
 *
 * [282] Expression Add Operators
 * [backtracking]
 */

// @lc code=start
class Solution {
    public List<String> addOperators(String num, int target) {
        // we need to consider every possible cases
        // remember to draw a backtracking tree like this
        // https://pic.leetcode-cn.com/db33e99ebe0208e2130f6a6351de6362d8535d74784265344e10796859cf11d5.jpg
        // first, let's only consider "+" and "-"
        List<String> ans = new ArrayList<>();
        dfsTrack(num, 0, target, ans, "", 0l, 0l);

        //"105"\n5
        return ans;
    }

    private void dfsTrack(String num, int start, int target, List<String> ans, String path, long eval, long pre) {
        if (start == num.length()) {
            // move to the end of the string, now check the result
            if (eval == target) {
                ans.add(path);
            }
        }

        for (int i=start; i<num.length(); i++) {
            if (i > start  && num.charAt(i) == '0') {
                // prune, the number can not start with 0
                continue;
            }

            long curNum = Long.parseLong(num.substring(start, i+1));
            if (start == 0) {
                // the first num
                dfsTrack(num, i+1, target, ans, path + curNum, curNum, curNum);
            } else {
                // "+"
                dfsTrack(num, i+1, target, ans, path + "+" + curNum, eval + curNum, curNum);

                // "-"
                dfsTrack(num, i+1, target, ans, path + "-" + curNum, eval - curNum, -curNum);

                // "*"
                // eval = eval - pre + pre * curNum
                // the pre in this case should pre * curNum
                // consider the case 3 * 4 * 5
                dfsTrack(num, i+1, target, ans, path + "*" + curNum, eval - pre + pre * curNum, curNum * pre);
            }

        }

    }
}
// @lc code=end


import java.util.*;

/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
class Solution {
    //https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
    //https://pic.leetcode-cn.com/298a80282ac3505fec3710abdc1e656c591cf7acaa3ba976151480729244b649-image.png
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        dfsBacktracking(s, ans, path);
        return ans;
    }

    private void dfsBacktracking(String s, List<List<String>> ans, List<String> path) {
        if (s.length() == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i=0; i<s.length(); i++) {
            String pre = s.substring(0, i+1);
            if (isPalindrome(pre)) {
                path.add(pre);

                dfsBacktracking(s.substring(i+1), ans, path);

                path.remove(path.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end


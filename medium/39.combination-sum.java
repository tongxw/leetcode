import java.util.*;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    // https://leetcode-cn.com/problems/combination-sum/solution/zu-he-zong-he-by-leetcode-solution/
    // https://assets.leetcode-cn.com/solution-static/39/39_fig1.png
    private List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        // backTrackingDfs(candidates, target, path, 0);
        dfsBackTracking(candidates,target, path, 0);
        return ans;
    }

    // TC: O(2^n)?  SC: O(target)
    private void backTrackingDfs(int[] candidates, int target, List<Integer> path, int i) {
        if (i == candidates.length) {
            return;
        }

        if (target == 0) {
            // found
            ans.add(new ArrayList<Integer>(path));
            return;
        }

        // try: not pick this number
        backTrackingDfs(candidates, target, path, i + 1);

        // try: pick this number
        if (target - candidates[i] >= 0) {
            path.add(candidates[i]);
            backTrackingDfs(candidates, target - candidates[i], path, i); // do not set i+1 !!
            path.remove(path.size() - 1);
        }
    }

    private void dfsBackTracking(int[] candidates, int target, List<Integer> path, int start) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(path));
            return;
        }

        // 关键点：i=start而不是i=0，去重
        for (int i=start; i<candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                path.add(candidates[i]);
                dfsBackTracking(candidates, target - candidates[i], path, i); // do not set i+1
                path.remove(path.size() - 1);
            }
        }
    }
}
// @lc code=end


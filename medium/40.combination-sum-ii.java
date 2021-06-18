import java.util.*;
/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    private Set<List<Integer>> ans = new HashSet<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfsBackTracking(candidates, target, 0, path);
        return new ArrayList<List<Integer>>(ans);
    }

    // how to remove the duplicated results?
    private void dfsBackTracking(int[] candidates, int target, int start, List<Integer> path) {
        if (target < 0) {
            // go back
            return;
        }

        if (target == 0) {
            // found
            // System.out.println("found: " + path);
            ans.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i=start; i<candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                path.add(candidates[i]);
                dfsBackTracking(candidates, target - candidates[i], i + 1, path);
                path.remove(path.size() - 1);
            } else {
                // prune for sorted array
                break;
            }
        }


        // if (start == candidates.length) {
        //     return;
        // }

        // System.out.println("target: " + target + " cur_num: " + candidates[i] + " path: " + path);

        // do not pick this number
        // dfsBackTracking(candidates, target, start + 1, path);

        // pick this number
        // if (target - candidates[start] >= 0) {
        //     path.add(candidates[start]);
        //     // System.out.println("target: " + (target - candidates[i]) + " num: " + candidates[i] + " path: " + path);
        //     dfsBackTracking(candidates, target - candidates[i], start + 1, path);
        //     path.remove(path.size() - 1);
        //     // System.out.println("target: " + (target - candidates[i]) + " num: " + candidates[i] + " path: " + path);
        // }
    }
}
// @lc code=end


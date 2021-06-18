import java.util.*;
/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    private Set<List<Integer>> ansSet = new HashSet<List<Integer>>();
    private List<List<Integer>> ansList = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        // dfsBackTracking(candidates, target, 0, path);
        dfsBackTrackingPrune(candidates, target, 0, path);
        // return new ArrayList<List<Integer>>(ansSet);
        return ansList;
    }

    // how to remove the duplicated results?
    // https://pic.leetcode-cn.com/1599718525-iXEiiy-image.png
    private void dfsBackTracking(int[] candidates, int target, int start, List<Integer> path) {
        if (target < 0) {
            // go back
            return;
        }

        if (target == 0) {
            // found
            // System.out.println("found: " + path);
            ansSet.add(new ArrayList<Integer>(path));
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
    }

    private void dfsBackTrackingPrune(int[] candidates, int target, int start, List<Integer> path) {
        if (target == 0) {
            // found
            // System.out.println("found: " + path);
            ansList.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i=start; i<candidates.length; i++) {
            // prune, if the same number in the same level
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }

            if (target - candidates[i] >= 0) {
                path.add(candidates[i]);
                // System.out.println("before => " + path + "，target = " + (target - candidates[i]));
                dfsBackTrackingPrune(candidates, target - candidates[i], i + 1, path);
                path.remove(path.size() - 1);
                // System.out.println("after => " + path + "，target = " + (target - candidates[i]));
            } else {
                // prune for sorted array
                break;
            }
        }
    }
}
// @lc code=end


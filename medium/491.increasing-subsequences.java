import java.util.*;

/*
 * @lc app=leetcode id=491 lang=java
 *
 * [491] Increasing Subsequences
 */

// @lc code=start
class Solution {
    // TODO: how to prune?
    public List<List<Integer>> findSubsequences(int[] nums) {
        // List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> path = new ArrayList<>();

        backTracking(nums, 0, path, set);

        // [1,2,3,1,1]
        return new ArrayList<>(set);
    }

    private void backTracking(int[] nums, int start, List<Integer> path, Set<List<Integer>> set) {
        if (path.size() >= 2) {
            set.add(new ArrayList<>(path));
        }

        for (int i=start; i<nums.length; i++) {
            if (path.isEmpty() || nums[i] >= path.get(path.size() - 1)) {
                if (i > start && nums[i] == nums[i-1]) { // must be ordered array!
                    // prune
                    continue;
                }

                path.add(nums[i]);
                backTracking(nums, i+1, path, set);
                path.remove(path.size() - 1);
            }
        }

    }
}
// @lc code=end


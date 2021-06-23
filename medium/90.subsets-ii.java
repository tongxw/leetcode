import java.util.*;

/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        dfsBackTracking(nums, 0, ans, path);

        return ans;
    }

    private void dfsBackTracking(int[] nums, int start, List<List<Integer>> ans, List<Integer> path) {
        ans.add(new ArrayList<>(path));
        for (int i=start; i<nums.length; i++) {
            if (i>start && nums[i] == nums[i-1]) {
                // prune
                continue;
            }

            path.add(nums[i]);
            dfsBackTracking(nums, i+1, ans, path);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end


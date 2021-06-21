import java.util.*;

/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
class Solution {
    private List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        Deque<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backTracking(nums, used, path);
        return ans;
    }

    private void backTracking(int[] nums, boolean[] used, Deque<Integer> path) {
        // exit
        if (path.size() == nums.length) {
            ans.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && used[i-1]) {
                continue;
            }

            if (used[i]) {
                continue;
            }

            used[i] = true;
            path.push(nums[i]);

            backTracking(nums, used, path);

            path.pop();
            used[i] = false;
        }
    }
}
// @lc code=end


import java.util.*;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();

        backTracking(nums, 0, ans, path);

        return ans;
    }

    private void backTracking(int[] nums, int start, List<List<Integer>> ans, List<Integer> path) {
        ans.add(new ArrayList<>(path));
        for (int i=start; i<nums.length; i++) {
            path.add(nums[i]);

            backTracking(nums, i+1, ans, path);

            path.remove(path.size() - 1);
        }
    }



    private List<List<Integer>> bitManipulation(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i=0; i < (1 << len); i++) {
            int pick = i;
            int j = 0;
            ArrayList<Integer> subSet = new ArrayList<Integer>();
            while (pick > 0) {
                if ((pick & 1) == 1) {
                    subSet.add(nums[j]);
                }
                pick >>= 1;
                j++;
            }

            ans.add(subSet);
        }


        return ans;
    }
}
// @lc code=end


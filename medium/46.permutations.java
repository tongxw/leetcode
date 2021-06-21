import java.util.*;
/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    private List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> pList = new ArrayList<>();
        HashSet<Integer> picked = new HashSet<>();
        // backTracking(nums, picked, pList);
        bfs(nums);

        return ans;
    }

    // TC: O(n*n!), SC: O(n*n!)
    private void backTracking(int[] nums, HashSet<Integer> picked, List<Integer> pList) {
        if (picked.size() == nums.length) {
            ans.add(new ArrayList<Integer>(pList));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (picked.contains(nums[i])) {
                continue;
            }
            picked.add(nums[i]);
            pList.add(nums[i]);
            backTracking(nums, picked, pList);
            picked.remove(nums[i]);
            pList.remove(pList.size() - 1);
        }
    }

    private void bfs(int[] nums) {
        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(new ArrayList<Integer>());
        while (!q.isEmpty()) {
            List<Integer> pList = q.poll();
            if (pList.size() == nums.length) {
                ans.add(pList);
            } else {
                for (int i=0; i<nums.length; i++) {
                    if (pList.indexOf(nums[i]) == -1) {
                        List<Integer> pListCopy = new ArrayList<>(pList);
                        pListCopy.add(nums[i]);
                        q.offer(pListCopy);
                    }
                }
            }

        }
    }
}
// @lc code=end


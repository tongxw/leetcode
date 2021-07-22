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

    // 此题time complexity无比蛋疼
    // (1) 首先来看Combination sum I和II的区别:
    // Combination sum 的input无dups, 但是input的元素可以重复利用
    // Combination sum II 的input有重复, 但是input的元素只能用一次
    // 
    // (2) 其次, 弄明白 Combination sum II的time complexity是怎么一回事儿
    // https://github.com/Deadbeef-ECE/Interview/blob/master/Leetcode/BackTracking/040_Combination_Sum_II.java
    
    // O(k * 2^n') time:
    // 此题可以转换成 combination sum II, 如何做呢, 举个栗子:
    // int[] arr = {2, 3, 4, 5, 6}, target = 10; 我们知道此题中,每个元素可以重复用, 
    // 其实, 如果把 arr 变成 {2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6}, 然
    // 后每个元素只能用一次, 就变成了combination sum II的要求了. 
    // 我们再看新数组, 元素多了很多, 多了多少? 
    // 那就是数组中所有小于等于target的元素E增加了ceil(target/E)个, 然后就可以用
    // combination sum II的方法分析复杂度了. 这里n'是新arr的大小

    // O(n) space:
    // one n is the recursion stack
    // another n is used when copying list
    // Both of them depend on the longest solution which is equal to 
    // target/(min in candidates) in this problem(可以再看下上面的例子, n就是新
    // arr中2的个数, 为ceil(10/2))
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


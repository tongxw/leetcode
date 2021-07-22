#
# @lc app=leetcode id=40 lang=python3
#
# [40] Combination Sum II
#

# @lc code=start
class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        def dfs(candidates: List[int], start: int, target: int, path: List[int]):
            if target == 0:
                ans.append(path.copy())
                return
    
            if start == len(candidates) or target < 0:
                return

            for i in range(start, len(candidates)):
                if target < candidates[i]:
                    continue
                if i != start and candidates[i] == candidates[i-1]:
                    continue

                path.append(candidates[i])
                dfs(candidates, i + 1, target - candidates[i], path)
                path.pop()
        
        ans = []
        path = []
        candidates.sort()
        dfs(candidates, 0, target, path)

        #[2,5,2,1,2]\n5
        return ans
        
# @lc code=end


#
# @lc app=leetcode id=39 lang=python3
#
# [39] Combination Sum
#

# @lc code=start
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def dfs(candidates: List[int], start: int, target: int, path: List[int]):
            if start == len(candidates) or target < 0:
                return
            if target == 0:
                ans.append(path.copy())
            else:
                for i in range(start, len(candidates)):
                    if target < candidates[i]:
                        # prune
                        continue

                    path.append(candidates[i])
                    dfs(candidates, i,  target - candidates[i], path)
                    path.pop()
        
        ans = []
        path = []
        dfs(candidates, 0, target, path)

        return ans
        
        
# @lc code=end


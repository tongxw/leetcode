#
# @lc app=leetcode id=47 lang=python3
#
# [47] Permutations II
#

# @lc code=start
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        def dfs(nums: List[int], path: List[int], visited: Set[int]):
            if len(path) == len(nums):
                ans.append(path.copy())
                return
            
            for i, num in enumerate(nums):
                if i > 0 and nums[i] == nums[i-1] and i-1 in visited:
                    continue

                if i in visited:
                    continue

                path.append(num)
                visited.add(i)
                dfs(nums, path, visited)
                visited.remove(i)
                path.pop()
            

        ans = []
        path = []
        visited = set()
        nums.sort()
        dfs(nums, path, visited)

        return ans

        
# @lc code=end


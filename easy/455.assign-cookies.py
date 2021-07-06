#
# @lc app=leetcode id=455 lang=python3
#
# [455] Assign Cookies
#

# @lc code=start
class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()

        ans = 0
        cookie = 0
        for greed in g:
            while cookie < len(s) and greed > s[cookie]:
                cookie += 1
            
            if cookie == len(s):
                break

            cookie += 1
            ans += 1
        
        # [1,2,3]\n[3]
        return ans
# @lc code=end


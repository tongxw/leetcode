#
# @lc app=leetcode id=821 lang=python3
#
# [821] Shortest Distance to a Character
#

# @lc code=start
class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        res = []

        c_pos = -10000 #s.length <= 10^4
        i = 0
        for char in s:
            if char == c:
                c_pos = i
            res.append(i - c_pos)
            i = i + 1
        
        c_pos = 10000 #s.length <= 10^4
        i = i - 1
        for char in s[::-1]:
            if char == c:
                c_pos = i;
            res[i] = min(res[i], c_pos - i)
            i = i - 1
        
        return res
        
# @lc code=end


#
# @lc app=leetcode id=3 lang=python3
#
# [3] Longest Substring Without Repeating Characters
#

# @lc code=start
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l = 0
        ans = 0
        charsInWindow = set()
        for r in range(len(s)):
            while s[r] in charsInWindow:
                charsInWindow.remove(s[l])
                l += 1
                
            charsInWindow.add(s[r])
            ans = max(ans, r-l+1)

        return ans
        
# @lc code=end


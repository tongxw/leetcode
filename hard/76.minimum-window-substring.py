#
# @lc app=leetcode id=76 lang=python3
#
# [76] Minimum Window Substring
#

# @lc code=start
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        def match():
            for i in range(len(chars_in_t)):
                if chars_in_t[i] > chars_in_window[i]:
                    return False
            return True

        if len(s) < len(t):
            return ""

        chars_in_t = [0] * 58
        chars_in_window = [0] * 58

        for c in t:
            chars_in_t[ord(c) - ord('A')] += 1

        min_len = len(s) + 1
        min_l = 0
        min_r = 0

        l = 0
        for r in range(len(s)):
            chars_in_window[ord(s[r]) - ord('A')] += 1
            while match():
                cur_len = r - l + 1
                if cur_len < min_len:
                    min_len = cur_len
                    min_l = l
                    min_r = r
                chars_in_window[ord(s[l]) - ord('A')] -= 1
                l += 1
        
        return "" if min_len == len(s) + 1 else s[min_l : min_r+1]

""" top voted
def minWindow(self, s, t):
    need, missing = collections.Counter(t), len(t)
    i = I = J = 0
    for j, c in enumerate(s, 1):
        missing -= need[c] > 0
        need[c] -= 1
        if not missing:
            while i < j and need[s[i]] < 0:
                need[s[i]] += 1
                i += 1
            if not J or j - i <= J - I:
                I, J = i, j
    return s[I:J]
"""
# @lc code=end


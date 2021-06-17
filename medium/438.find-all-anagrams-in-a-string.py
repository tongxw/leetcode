#
# @lc app=leetcode id=438 lang=python3
#
# [438] Find All Anagrams in a String
#

# @lc code=start
import collections
from typing import List

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        def isAnagram():
            for i in range(len(chars_in_p)):
                if chars_in_p[i] != chars_in_window[i]:
                    return False
            return True

        if len(s) < len(p):
            return []

        chars_in_p = [0] * 26
        for c in p:
            chars_in_p[ord(c) - ord('a')] += 1

        chars_in_window = [0] * 26
        r = 0
        while (r < len(p) - 1):
            c = s[r]
            chars_in_window[ord(c) - ord('a')] += 1
            r += 1

        ans = []
        l = 0
        while (r < len(s)):
            chars_in_window[ord(s[r]) - ord('a')] += 1
            if isAnagram():
                ans.append(l)
            chars_in_window[ord(s[l]) - ord('a')] -= 1

            l += 1
            r += 1


        return ans
# @lc code=end


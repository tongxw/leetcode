#
# @lc app=leetcode id=20 lang=python3
#
# [20] Valid Parentheses
#

# @lc code=start
class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) & 1 == 1:
            return False
        
        brackets = {
            '(' : ')',
            '{' : '}',
            '[' : ']'
        }

        stack = []
        for c in s:
            if c in brackets.keys():
                stack.append(c)
            else:
                if not stack:
                    return False
                
                top = stack.pop()
                if brackets[top] != c:
                    return False

        return not stack
    
    def isValid2(self, s: str) -> bool:
        while len(s) > 0:
            l = len(s)
            s = s.replace('()','').replace('{}','').replace('[]','')
            if l==len(s): return False
        return True

# @lc code=end


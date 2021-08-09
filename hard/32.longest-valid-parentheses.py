#
# @lc app=leetcode id=32 lang=python3
#
# [32] Longest Valid Parentheses
#

# @lc code=start
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        # https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
        # return self.stack(s)
        # return self.greedy(s)
        # return self.bruteForce(s)
        return self.dp(s)

    def dp(self, s: str) -> int:
        # dp[i]: longest valid parentheses end with s[i]
        # if s[i] == '(', dp[i] = 0
        # if s[i] == ')'
        #   1. if s[i-1] == '(', the foramt is like '....()' : dp[i] = dp[i-2] + 2
        #   2. if s[i-1] == '), the format is like '....))' : 
        #       get the last invalid parenthese's left index = i - dp[i-1] - 1
        #       if s[i - dp[i-1] - 1] = '(', dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2]
        ans = 0
        dp = [0] * len(s)
        for i, c in enumerate(s):
            if c == ')' and i >= 1:
                if s[i-1] == '(':
                    dp[i] = dp[i-2] + 2 if i >= 2 else 2
                else:
                    idx = i - dp[i-1] - 1
                    if idx >= 0 and s[idx] == '(':
                        dp[i] = dp[i-1] + 2
                        dp[i] += dp[idx - 1] if idx >= 1 else 0
                ans = max(ans, dp[i])
        
        # ""()""
        # "")()())""
        return ans


    def bruteForce(self, s: str) -> int:
        def isValid(s):
            if len(s) & 1 == 1:
                return False
            
            stack = []
            for c in s:
                if c == '(':
                    stack.append(c)
                elif not stack:
                    return False
                else:
                    stack.pop()
            
            return not stack

        ans = 0
        for i in range(len(s)):
            for j in range(i):
                if isValid(s[j:i]):
                    ans = max(ans, i - j + 1)
        return ans

    def stack(self, s: str) -> int:
        # 1. iter str, if it is '(', push the index of this pos to the stack
        # 2. if it is ')',
        # 2.1 if the stack is empty, this ')' is not matched. push the index to the stack
        # 2.1 if the stack is not empty, pop the stack. the longest parentheses end with this ')' is the index minus the top of the stack
        # the bottom of the stack is the index of unmatched ')'
        stack = [-1]
        ans = 0
        for i, c in enumerate(s):
            if c == '(':
                stack.append(i)
            else:
                stack.pop()
                if not stack:
                    stack.append(i)
                else:
                    ans = max(ans, i - stack[-1])

        # "")()())""
        return ans

    def greedy(self, s: str) -> int:
        def updateAns(c, left, right, ans, from_left = True):
            if c == '(':
                left += 1
            else:
                right += 1
            
            if left == right:
                # match
                ans = max(ans, left + right)
            elif (from_left and left < right) or (not from_left and left > right):
                left, right = 0, 0
            
            return left, right, ans

        left, right, ans = 0, 0, 0

        # from 0 to len(s)
        for c in s:
            left, right, ans = updateAns(c, left, right, ans)
        
        # previous solution miss one case,
        # where the '('s are always more than ')', say '(()'

        left, right = 0, 0

        # from len(s) to 0
        for i in range(len(s) - 1, -1, -1):
            left, right, ans = updateAns(s[i], left, right, ans, False)

        return ans
        
# @lc code=end


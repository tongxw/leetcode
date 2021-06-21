#
# @lc app=leetcode id=695 lang=python3
#
# [695] Max Area of Island
#

# @lc code=start
import collections

class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        self.stack = 0
        def dfsArea(grid, row, col):
            # self.stack += 1
            print("stack size: %d" % self.stack)
            if row < 0 or row >= len(grid) or col < 0 or col >= len(grid[0]):
                # self.stack -= 1
                return 0
            if grid[row][col] != 1:
                # self.stack -=1
                return 0
            
            # visited land
            grid[row][col] = 2

            return 1 + dfsArea(grid, row + 1, col) + dfsArea(grid, row - 1, col) + \
                dfsArea(grid, row, col + 1) + dfsArea(grid, row, col - 1)
    
        def bfsArea(grid, row, col):
            q = []
            q.append((row, col))

            ans = 0
            while q:
                # print("q size: %d" % len(q))
                i, j = q.pop()
                if grid[i][j] != 1:
                    continue

                grid[i][j] = 2
                ans += 1

                if i - 1 >= 0:
                    # do not use q.append({i, j})
                    # {} is a set, order is not guaranteed!
                    q.append((i - 1, j))
                if i + 1 < len(grid):
                    q.append((i + 1, j))
                if j - 1 >= 0:
                    q.append((i, j - 1))
                if j + 1 < len(grid[0]):
                    q.append((i, j + 1))

            return ans

        ans = 0
        for row, row_vals in enumerate(grid):
            for col, grid_val in enumerate(row_vals):
                if grid_val == 1:
                    ans = max(ans, dfsArea(grid, row, col))
                    # ans = max(ans, bfsArea(grid, row, col))

        return ans

# @lc code=end


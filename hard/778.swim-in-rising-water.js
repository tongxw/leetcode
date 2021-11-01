/*
 * @lc app=leetcode id=778 lang=javascript
 *
 * [778] Swim in Rising Water
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var swimInWater = function(grid) {
  function dfsPossible(time, row, col, grid, visited) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
      return false;
    }


    if (visited[row][col]) {
      return false;
    }

    if (grid[row][col] > time) {
      // can't swim
      return false;
    }

    if (row == grid.length - 1 && col == grid[0].length - 1) {
      return true;
    }

    visited[row][col] = true;
    return dfsPossible(time, row + 1, col, grid, visited) ||
      dfsPossible(time, row - 1, col, grid, visited) ||
      dfsPossible(time, row, col + 1, grid, visited) ||
      dfsPossible(time, row, col - 1, grid, visited);
  }
  
  
  let min = 0;
  let max = 0;
  for (let i=0; i<grid.length; i++) {
    for (let j=0; j<grid[0].length; j++) { // O(n)
      max = Math.max(max, grid[i][j]);
    }
  }

  let ans = 0;
  while (min <= max) { // O(log(max - min))
    let mid = min + ((max - min) >> 1);
    
    let visited = new Array(grid.length);
    for (let i=0; i<visited.length; i++) { // TC - O(n2)
      visited[i] = new Array(grid[0].length).fill(false);
    }

    if (dfsPossible(mid, 0, 0, grid, visited)) { // O(n^2)
      ans = mid;
      max = mid - 1;
    } else {
      min = mid + 1;
    }
  }

  return ans;
};
// @lc code=end


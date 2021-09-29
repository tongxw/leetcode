/*
 * @lc app=leetcode id=447 lang=javascript
 *
 * [447] Number of Boomerangs
 * [hashmap]
 */

// @lc code=start
/**
 * @param {number[][]} points
 * @return {number}
 */
var numberOfBoomerangs = function(points) {
    // for each point i, calculate the dist of every other point j
    // use a hashmap to save, how many points have the same dist to point i
    // then, the boomerangs start with point i, is a permutation number of each dist
    // do a loop for every points and sum the numbers
    let ans = 0;
    for (let i=0; i<points.length; i++) {
      const distMap = new Map();
      for (let j=0; j<points.length; j++) {
        if (i == j) {
          continue;
        }
        const dist = Math.pow(points[i][0] - points[j][0], 2) +  Math.pow(points[i][1] - points[j][1], 2);
        const count = distMap.get(dist) || 0;
        distMap.set(dist, count + 1);
      }

      for (const entry of distMap) {
        ans += entry[1] * (entry[1] - 1);
      }
    }

    // [[0,0],[1,0],[-1,0],[0,1],[0,-1]]
    return ans;
};
// @lc code=end


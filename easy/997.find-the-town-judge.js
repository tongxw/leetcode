/*
 * @lc app=leetcode id=997 lang=javascript
 *
 * [997] Find the Town Judge
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number[][]} trust
 * @return {number}
 */
var findJudge = function(n, trust) {
    let inDegree = new Array(n+1).fill(0);
    let outDegree = new Array(n+1).fill(0);

    for (let edge of trust) {
      // edge[0] -> edge[1]
      outDegree[edge[0]] += 1;
      inDegree[edge[1]] += 1;
    }

    for (let i=1; i<=n; i++) {
      if (inDegree[i] === n - 1 && outDegree[i] === 0) {
        return i;
      }
    }

    return -1;
};
// @lc code=end


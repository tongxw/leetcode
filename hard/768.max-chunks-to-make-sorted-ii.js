/*
 * @lc app=leetcode id=768 lang=javascript
 *
 * [768] Max Chunks To Make Sorted II
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {number}
 */
var maxChunksToSorted = function(arr) {
  let monoStack = [];
  for (let num of arr) {
    if (monoStack.length > 0 && num < monoStack[monoStack.length - 1]) {
      let top = monoStack[monoStack.length - 1];
      while (monoStack.length > 0 && num < monoStack[monoStack.length - 1]) {
        monoStack.pop();
      }
      monoStack.push(top);
    } else {
      monoStack.push(num);
    }
  }

  console.log(monoStack);

  //[1,1,0,0,1]
  // [0,2,1,3,4,4]
  return monoStack.length;
};
// @lc code=end


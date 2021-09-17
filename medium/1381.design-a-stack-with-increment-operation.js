/*
 * @lc app=leetcode id=1381 lang=javascript
 *
 * [1381] Design a Stack With Increment Operation
 */

// @lc code=start
/**
 * @param {number} maxSize
 */
var CustomStack = function(maxSize) {
  this.maxSize = maxSize;
  this.stack = [];
  this.increments = new Array(maxSize).fill(0);
};

/** 
 * @param {number} x
 * @return {void}
 */
CustomStack.prototype.push = function(x) {
  if (this.stack.length < this.maxSize) {
    this.stack.push(x);
  }
};

/**
 * @return {number}
 */
CustomStack.prototype.pop = function() {
  let size = this.stack.length;
  if (size === 0) {
    return -1;
  } else {
    let val = this.increments[size - 1];
    this.increments[size - 1] = 0;
    if (size - 2 >= 0) {
      this.increments[size - 2] += val;
    }

    return this.stack.pop() + val;
  }
};

/** 
 * @param {number} k 
 * @param {number} val
 * @return {void}
 */
CustomStack.prototype.increment = function(k, val) {
  let size = Math.min(this.stack.length, k);
  this.increments[size - 1] += val;
};

/** 
 * Your CustomStack object will be instantiated and called as such:
 * var obj = new CustomStack(maxSize)
 * obj.push(x)
 * var param_2 = obj.pop()
 * obj.increment(k,val)
 */
// @lc code=end


/*
 * @lc app=leetcode id=30 lang=javascript
 *
 * [30] Substring with Concatenation of All Words
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string[]} words
 * @return {number[]}
 */
var findSubstring = function(s, words) {
  const wordCounters = new Map();
  for (const word of words) {
    const counter = wordCounters.get(word) || 0;
    wordCounters.set(word, counter + 1);
  }

  // sliding window with fixed length
  const ans = [];
  const windowLength = words.length * words[0].length;
  for (let i=0; i<=s.length - windowLength; i++) {
    //const windowStr = s.substring(i, i + windowLength);
    const newCounters = new Map(wordCounters);
    let isMatch = true;
    // console.log('checking idx: ' + i);
    for (let j=i; j<i+windowLength; j+=words[0].length) {
      const word = s.substring(j, j+words[0].length);
      // console.log('check word: ' + word);
      const counter = newCounters.get(word) || 0;
      if (counter > 0) {
        newCounters.set(word, counter - 1);
      } else {
        // not match
        // console.log('check fail: ' + word);
        isMatch = false;
        break;
      }
    }

    if (isMatch) {
      ans.push(i);
    }
  }

  //""wordgoodgoodgoodbestword"\n["word","good","best","good"]"
  return ans;
};
// @lc code=end


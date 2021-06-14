/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minK = 1;
        int maxK = 0;
        for (int pile : piles) {
            maxK = Math.max(maxK, pile);
        }

        while (minK <= maxK) {
            int midK = (minK + maxK) / 2;
            if (canFinish(piles, h, midK)) {
                maxK = midK - 1;
            } else {
                // can not eat all within mid
                minK = midK + 1;
            }
        }

        // [30,11,23,4,20]\n5
        return minK;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        for (int pile : piles) {
            int count = (pile - 1 )/ k + 1;
            h -= count;
            if (h < 0) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end


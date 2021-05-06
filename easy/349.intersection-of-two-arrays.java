import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // time O(n)
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num: nums1) {
            set.add(num);
        }

        HashSet<Integer> intersect = new HashSet<Integer>();
        for (int num: nums2) {
            if (set.contains(num)) {
                intersect.add(num);
            }
        }

        int[] ret = new int[intersect.size()];
        int i = 0;
        for (int num: intersect) {
            ret[i] = num;
            i++;
        }

        return ret;
    }
}
// @lc code=end


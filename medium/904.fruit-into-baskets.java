import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=904 lang=java
 *
 * [904] Fruit Into Baskets
 */

// @lc code=start
class Solution {
    public int totalFruit(int[] tree) {
        if (tree.length <= 2) {
            return tree.length;
        }

        int l = 0;
        int ans = 0;
        HashMap<Integer, Integer> windowMap = new HashMap<>();
        for (int r=0; r<tree.length; r++) {
            windowMap.put(tree[r], windowMap.getOrDefault(tree[r], 0) + 1);
            while (getTypes(windowMap) >= 3) {
                windowMap.put(tree[l], windowMap.getOrDefault(tree[l], 0) - 1);
                if (windowMap.getOrDefault(tree[l], 0) <= 0) {
                    windowMap.remove(tree[l]);
                }
                l++;
            }

            ans = Math.max(ans, r - l + 1);
            // if (getTypes(windowMap) == 2) {
            //     System.out.println("r: " + r + "l: " + l);
            //     ans = Math.max(ans, r - l + 1);
            //     r++;
            // } else if (getTypes(windowMap) > 2) {
            //     //move left
            //     while (getTypes(windowMap) != 1 && l <= r) {
            //         windowMap.put(tree[l], windowMap.getOrDefault(tree[l], 0) - 1);
            //         // window[tree[l]] -= 1;
            //         if (windowMap.getOrDefault(tree[l], 0) <= 0) {
            //             windowMap.remove(tree[l]);
            //         }
            //         l++;
            //     }
            // } else {
            //     r++;
            // }
        }

        //[1,2,3,2,2]
        //[3,3,3,1,2,1,1,2,3,3,4]
        return ans;
    }

    private int getTypes(HashMap<Integer, Integer> windowMap) {
        return windowMap.keySet().size();
    }
}
// @lc code=end


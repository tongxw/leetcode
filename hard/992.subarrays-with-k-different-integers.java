import java.util.HashMap;

/*
 * @lc app=leetcode id=992 lang=java
 *
 * [992] Subarrays with K Different Integers
 */

// @lc code=start
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // return bruteForce(nums, k);
        

        // return atMostK(nums, k) - atMostK(nums, k - 1);
        return justK(nums, k);
    }

    /* 
     * 对于任意一个右端点，能够与其对应的左端点们必然相邻。
     * 假设左端点不相邻，有[...l1,l,l2....r...]
     * 那么[l1, r]恰好有k个不同整数，则[l, r]至多不超过k的不同整数
     * [l2, r]恰好有k个不同整数，则[l, r]至少有k个不同整数
     * 则[l, r]也是恰好k个整数。
     * 
     * 所以可以用三指针法，两个左指针来计算l1, l2的位置
     */
    private int justK(int[] nums, int k) {
        int l1 = 0;
        int l2 = 0;
        int ret = 0;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int r=0; r<nums.length; r++) {
            map1.put(nums[r], map1.getOrDefault(nums[r], 0) + 1);
            map2.put(nums[r], map2.getOrDefault(nums[r], 0) + 1);

            // printMap(map1);

            while (map1.size() > k) {
                map1.put(nums[l1], map1.getOrDefault(nums[l1], 0) - 1);
                //printMap(map1);
                if (map1.getOrDefault(nums[l1], 0) == 0) {
                    map1.remove(nums[l1]);
                }

                l1++;
            }

            while (map2.size() > k - 1) {
                map2.put(nums[l2], map2.getOrDefault(nums[l2], 0) - 1);
                if (map2.getOrDefault(nums[l2], 0) == 0) {
                    map2.remove(nums[l2]);
                }

                l2++;
            }

            ret += l2 - l1;
        }

        return ret;
    }

    private int atMostK(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        int l = 0;
        int total = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int r=0; r<nums.length; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while (map.size() > k && l <= r) {
                map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);
                if (map.getOrDefault(nums[l], 0) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            } 
            
            total += r - l + 1 ;
        }

        return total;
    }

    private int bruteForce(int[] nums, int k) {
        int total = 0;
        for (int i=0; i<nums.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j=i; j<nums.length; j++) {
                // count how many different numbers in [i...j]
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                if (map.size() == k) {
                    total++;
                } else if (map.size() > k) {
                    break;
                }
            }
        }

        return total;
    }

    private void printMap(HashMap<Integer, Integer> inMap) {
        StringBuffer out = new StringBuffer();
        for (Integer key : inMap.keySet()) {
            out.append(key);
            out.append(":");
            out.append(inMap.get(key));
            out.append(" ");
        }
        System.out.println(out.toString());
    }

}
// @lc code=end


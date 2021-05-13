import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
 * @lc app=leetcode id=380 lang=java
 *
 * [380] Insert Delete GetRandom O(1)
 */

// @lc code=start
class RandomizedSet {

    private HashMap<Integer, Integer> map; // val => index in the list
    private ArrayList<Integer> list;
    private Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.remove(val);

            // do not remove the val from list, it is not O(1)
            int lastVal = list.remove(list.size() - 1); // this is O(1)
            // set the last val to the index pos
            if (val != lastVal) {
                list.set(index, lastVal);

                // remember to update the map too
                map.put(lastVal, index);
            }

            return true;
        } else {
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int rndIndex = rand.nextInt(list.size());
        return list.get(rndIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end


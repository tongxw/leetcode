import java.util.*;

/*
 * @lc app=leetcode id=706 lang=java
 *
 * [706] Design HashMap
 */

// @lc code=start
class MyHashMap {
    // private int[] data;
    private List<int[]>[] data;
    private int capacity = 100;
    /** Initialize your data structure here. */
    public MyHashMap() {
        // data = new int[1000001];
        // Arrays.fill(data, -1);
        data = new List[capacity];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        // data[key] = value;
        int[] entry = new int[] { key, value };
        int hash = key % capacity;

        List<int[]> list = data[hash];
        if (list == null) {
            list = new ArrayList<>();
            list.add(entry);
            data[hash] = list;
            return;
        }

        for (int[] node: list) {
            if (node[0] == entry[0]) {
                // found, update
                node[1] = entry[1];
                return;
            }
        }

        // not found
        list.add(entry);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        // return data[key];
        int hash = key % capacity;
        List<int[]> list = data[hash];
        if (list == null) {
            return -1;
        }
        for (int[] node: list) {
            if (node[0] == key) {
                return node[1];
            }
        }

        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        // data[key] = -1;

        int hash = key % capacity;
        List<int[]> list = data[hash];
        if (list != null) {
            int idx = 0;
            while (idx < list.size()) {
                int[] node = list.get(idx);
                if (node[0] == key) {
                    break;
                }
                idx++;
            }

            if (idx < list.size()) {
                list.remove(idx);
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// @lc code=end


import jdk.internal.util.Preconditions;

/*
 * @lc app=leetcode id=677 lang=java
 *
 * [677] Map Sum Pairs
 */

// @lc code=start
class MapSum {

    /** Initialize your data structure here. */
    int preCount = 0;
    int val = 0;
    MapSum[] children;
    public MapSum() {
        this.preCount = 0;
        this.val = 0;
        this.children = new MapSum[26];
    }
    
    public void insert(String key, int val) {
        int oldVal = search(key);
        MapSum node = this;
        for (char c : key.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new MapSum();
            }
            node = node.children[idx];
            node.preCount += val - oldVal;
        }

        node.val = val;
        
    }

    private int search(String key) {
        MapSum node = this;
        for (char c : key.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                return 0;
            }
            node = node.children[idx];
        }

        return node.val;

    }
    
    //["MapSum", "insert", "sum", "insert", "insert", "sum"]\n[[], ["apple",3], ["ap"], ["app",2], ["apple", 2], ["ap"]]
    public int sum(String prefix) {
        MapSum node = this;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                return 0;
            }
            node = node.children[idx];
        }

        return node.preCount;
        
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
// @lc code=end


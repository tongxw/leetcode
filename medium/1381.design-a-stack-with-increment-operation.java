import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode id=1381 lang=java
 *
 * [1381] Design a Stack With Increment Operation
 */

// @lc code=start
class CustomStack {
    private ArrayList<Integer> arr;
    private int maxSize = 0;
    private HashMap<Integer, Integer> incrementRecord;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new ArrayList<Integer>();
        this.incrementRecord = new HashMap<Integer, Integer>();
    }
    
    public void push(int x) {
        if (arr.size() == maxSize) {
            return;
        }

        arr.add(x);
    }

    // public int pop() {
    //     if (arr.size() == 0) {
    //         return -1;
    //     } else {
    //         return arr.get(arr.size() - 1);
    //     }
    // }
    
    public int pop() {
        int size = arr.size();
        if (size == 0) {
            return -1;
        }

        int lastIndex = size;
        int last = arr.remove(lastIndex - 1);

        int increment = 0;
        if (incrementRecord.containsKey(lastIndex)) {
            increment = incrementRecord.get(lastIndex);
            incrementRecord.remove(lastIndex);
            incrementRecord.put(lastIndex - 1, incrementRecord.getOrDefault(lastIndex - 1, 0) + increment);
        }

        return last + increment;
    }
    
    // public void increment(int k, int val) {
    //     for (int i=0; i<arr.size() && k>0; i++,k--) {
    //         arr.set(i, arr.get(i) + val);
    //     }
    // }

    public void increment(int k, int val) {
        int stackSize = this.arr.size();
        int totalElements = stackSize > k ? k : stackSize;

        incrementRecord.put(totalElements, incrementRecord.getOrDefault(totalElements, 0) + val);
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
// @lc code=end


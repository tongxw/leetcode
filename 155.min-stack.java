import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> data;
    private Stack<Integer> min;


    public MinStack() {
        data = new Stack<Integer>();
        min = new Stack<Integer>();
        // min.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        data.push(val);

        // keep tracking the all the "min" values
        // condition MUST BE <=
        if (min.empty() || val <= min.peek()) {
            min.push(val);
        }
    }
    
    public void pop() {
        int val = data.pop();

        if (val == min.peek()) {
            min.pop();
        }
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return min.peek();
    }

    // private LinkedList<Integer> l = null;
    // private int min;

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end


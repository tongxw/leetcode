import java.util.Stack;

/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start
class MyQueue {
    private Stack<Integer> inStack = null;
    private Stack<Integer> outStack = null;

    /** Initialize your data structure here. */
    public MyQueue() {
         inStack = new Stack<Integer>();
         outStack = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!outStack.empty()) {
            inStack.push(outStack.pop());
        }

        inStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!inStack.empty()) {
            outStack.push(inStack.pop());
        }
        
        return outStack.pop();
        // int ret = outStack.pop();

        // while (!outStack.empty()) {
        //     inStack.add(outStack.pop());
        // }

        // return ret;
    }
    
    /** Get the front element. */
    public int peek() {
        while (!inStack.empty()) {
            outStack.push(inStack.pop());
        }
        
        return outStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end


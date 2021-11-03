/*
 * @lc app=leetcode id=225 lang=java
 *
 * [225] Implement Stack using Queues
 * [design]
 */

// @lc code=start
class MyStack {
    Queue<Integer> q;
    Queue<Integer> helper;
    
    public MyStack() {
        q = new ArrayDeque<>();
        helper = new ArrayDeque<>();
    }
    
    // 思路就是先把x放进队列，然后把队列里已经存在的元素，再重新入队一遍，这样x就是最先入队的了，一会pop()的时候直接出队
    public void push(int x) {
        helper.offer(x);
        // now move all the elements from q to helper
        while (!q.isEmpty()) {
            helper.offer(q.poll());
        }
        
        // now, if we poll() from helper, x will get out.
        // swap helper and q
        Queue<Integer> temp = q;
        q = helper;
        helper = temp;
        
        // note that we can also use only one queue
        // int n = q.size();
        // q.offer(x);
        // while (n > 0) {
        //     q.offer(q.poll());
        //     n--;
        // }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end


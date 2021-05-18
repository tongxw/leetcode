import java.util.Stack;
/*
 * @lc app=leetcode id=901 lang=java
 *
 * [901] Online Stock Span
 */

// @lc code=start
class StockSpanner {
    Stack<Integer> priceStack;
    Stack<Integer> indexStack;
    public StockSpanner() {
        priceStack = new Stack<Integer>();
        indexStack = new Stack<Integer>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!priceStack.isEmpty() && price >= priceStack.peek()) {
            // next price is higher, now we need to check the history
            priceStack.pop();
            span += indexStack.pop();
        }

        priceStack.push(price); 
        indexStack.push(span);

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end


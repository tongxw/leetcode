import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // to keep n+1/2 small numbers
    private PriorityQueue<Integer> minHeap; // to keep n - (n+1/2) big numbers

    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((num1, num2) -> { return num2 - num1; });
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // if (maxHeap.isEmpty()) {
        //     maxHeap.add(num);
        // } else if (minHeap.isEmpty()) {
        //     minHeap.add(num);
        // } else {
        //     if (num > minHeap.peek()) {
        //         maxHeap.add(num);
        //     } else {
        //         minHeap.add(num);
        //     }
        // }

        // Key: first add to the heap, then adjust!
        if (maxHeap.isEmpty() || maxHeap.peek() > num) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        int len1 = maxHeap.size();
        int len2 = minHeap.size();

        if (len1 == len2) {
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end


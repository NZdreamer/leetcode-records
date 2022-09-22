import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
class MedianFinder {
    
    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;

    public MedianFinder() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>((a, b) -> (b - a));
    }
    
    public void addNum(int num) {
        if (!maxheap.isEmpty() && num < maxheap.peek()) {   // error: forget !maxheap.isEmpty()
            maxheap.add(num);
            if (maxheap.size() > minheap.size()) {
                minheap.add(maxheap.poll());
            }
        }
        else {
            minheap.add(num);
            if (minheap.size() > maxheap.size()) {
                maxheap.add(minheap.poll());
            }
        }
    }
    
    public double findMedian() {
        if (minheap.size() == maxheap.size()) {
             // return (minheap.peek() + maxheap.peek()) / 2.0;
            return (double)(minheap.peek() + maxheap.peek()) / 2;   // error: forget to turn int into double
        }
        else if (minheap.size() > maxheap.size()) {
            return minheap.peek();
        }
        else {
            return maxheap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end


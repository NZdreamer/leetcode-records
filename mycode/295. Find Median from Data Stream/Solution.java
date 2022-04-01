class MedianFinder {
    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;

    public MedianFinder() {
        minheap = new PriorityQueue();
        maxheap = new PriorityQueue<>((a,b) -> (b - a));
    }

    public void addNum(int num) {
        minheap.add(num);
        maxheap.add(minheap.poll());
        if (maxheap.size() > minheap.size()) minheap.add(maxheap.poll());
    }

    public double findMedian() {
        if (minheap.size() > maxheap.size()) return minheap.peek();
        else {
            double mid = (minheap.peek() + maxheap.peek()) / (double)2;
            return mid;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
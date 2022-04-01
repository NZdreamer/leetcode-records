import java.util.*;

class KthLargest {
    PriorityQueue<Integer> minHeap = new PriorityQueue();
    int k = 0;


    public KthLargest(int k, int[] nums) {
        // Arrays.sort(nums, Collections.reverseOrder());   // xxx Arrays.sort() can not sort int, but Integer
        // PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        // for (int num : nums) {
        //     maxHeap.add(num);
        // }
        // if (maxHeap.size() < k) {
        //     for (int i = 0; i < k; i++) {
        //         this.minHeap.add(maxHeap.poll());
        //     }
        //     this.k = k;
        // }
        this.k = k;
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            }
            else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            }
        }

    }


    public int add(int val) {
        if (minHeap.size() < k) minHeap.add(val);
        else if (val > minHeap.peek()) {
            this.minHeap.poll();
            this.minHeap.add(val);

        }
        return minHeap.peek();

    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        // PriorityQueue<Integer> maxHeap = new PriorityQueue(stones.length, new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer a, Integer b) {
        //         return b - a;
        //     }
        // });

        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());

        for (int i = 0; i < stones.length; i++) {
            maxHeap.add(stones[i]);
        }

        while (maxHeap.size() > 1) {
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            if (a != b) {
                maxHeap.add(a - b);
            }
        }
        if (maxHeap.size() == 0) return 0;
        else return maxHeap.poll();

    }
}
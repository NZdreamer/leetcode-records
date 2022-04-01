import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>((o1, o2) -> (o1.getValue() - o2.getValue()));   // need <> !!!
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.add(entry);
            }
            else if (minHeap.peek().getValue() < entry.getValue()) {
                minHeap.poll();
                minHeap.add(entry);
            }
        }


        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll().getKey();
        }

        return res;

//         List<Integer> list = new ArrayList();

//         List<Integer>[] buckets = new List[nums.length + 1];

//         for (int key : hm.keySet()) {
//             int f = hm.get(key);
//             if (buckets[f] == null) {
//                 buckets[f] = new ArrayList();
//             }
//             buckets[f].add(key);
//         }

//         int[] res = new int[k];
//         int j = 0;

//         for (int i = buckets.length - 1; i > 0; i--) {
//             if (j < k) {
//                 if (buckets[i] != null) {
//                     for (int num : buckets[i]) {
//                         res[j] = num;
//                         j++;
//                     }
//                 }
//             }
//         }

//         return res;


    }
}
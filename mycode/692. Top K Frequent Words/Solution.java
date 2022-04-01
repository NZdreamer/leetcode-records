import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hm=  new HashMap();
        for (String word : words) {
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }


        PriorityQueue<String> minHeap = new PriorityQueue<>(
                (a, b) -> hm.get(a).equals(hm.get(b)) ? b.compareTo(a) : (hm.get(a) - hm.get(b))
        );



        // PriorityQueue<Map.Entry<String, Integer> minHeap = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));
        for (String s : hm.keySet()) {
            minHeap.add(s);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // for (Map.Entry<String, Integer> entry : hm.entrySet()) {
        //     if (minHeap.size() < k) {
        //         minHeap.add(entry.getKey());
        //     }
        //     else if (hm.get(minHeap.peek()) < entry.getValue()) {
        //         minHeap.poll();
        //         minHeap.add(entry.getKey());
        //     }
        // }

        List<String> res = new ArrayList();
        while (minHeap.size() > 0) {
            res.add(0, minHeap.poll());
        }

        return res;

        // List<Map.Entry<String, Integer>> entryList = new List();
        // while (minHeap.size() > 0) {
        //     entryList.add(minHeap.poll());
        // }


    }
}
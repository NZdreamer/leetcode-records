import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<List<Integer>> heap = new PriorityQueue<>((o1, o2) -> o1.get(1) - o2.get(1));
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        }

        for (int key : map.keySet()) {
            List<Integer> list = new ArrayList<>();
            list.add(key);
            list.add(map.get(key));
            heap.offer(list);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[heap.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = heap.poll().get(0);
        }

        return res;
    }
}
// @lc code=end


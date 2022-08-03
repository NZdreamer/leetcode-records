import java.util.*;
/*
 * @lc app=leetcode id=797 lang=java
 *
 * [797] All Paths From Source to Target
 */

// @lc code=start
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> onPath = new LinkedList<>();
        traverse(graph, res, onPath, 0);
        return res;
    }

    public void traverse(int[][] graph, List<List<Integer>> res, List<Integer> onPath, int cur) {
        onPath.add(cur); 
        if (cur == graph.length - 1) {
            res.add(new LinkedList<>(onPath));
        }
        for (int v : graph[cur]) {
            traverse(graph, res, onPath, v);
        }
        onPath.remove(onPath.size() - 1);
    }
}
// @lc code=end


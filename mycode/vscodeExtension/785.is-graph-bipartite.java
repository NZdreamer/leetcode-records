/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

// @lc code=start
class Solution {
    boolean isBi = true;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) {
                dfs(graph, colors, i, 1);
            }
        }
        return isBi;
    }

    public void dfs (int[][] graph, int[] colors, int node, int c) {
        if (!isBi) return;
        if (colors[node] != 0) {
            return;
        }
        colors[node] = -c;
        for (int child : graph[node]) {
            if (colors[child] == colors[node]) {
                isBi = false;
                return;
            }
            dfs(graph, colors, child, -c);
        }
    }


}
// @lc code=end


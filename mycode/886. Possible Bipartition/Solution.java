class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] color = new int[n];
        for (int[] dislike : dislikes) {
            int p1 = dislike[0] - 1;
            int p2 = dislike[1] - 1;
            graph[p1].add(p2);
            graph[p2].add(p1);
        }
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (traverse(graph, color, i, 1) == false) return false;
            }
        }
        return true;
    }
    
    // check cur node
    // public boolean traverse(List<Integer>[] graph, int[] color, int cur, int validColor) {
    //     if (color[cur] != 0) {
    //         if (color[cur] == validColor) return true;
    //         else return false;
    //     }
    //     color[cur] = validColor;
    //     for (int v : graph[cur]) {
    //         if (traverse(graph, color, v, -validColor) == false) return false;
    //     }
    //     return true;
    // }
    
    
    // color cur node and its adjacent nodes, return false if two adjacent nodes has the same color
    public boolean traverse(List<Integer>[] graph, int[] color, int cur, int validColor) {
        color[cur] = validColor;
        for (int v : graph[cur]) {
            if (color[v] == 0) {
                if (traverse(graph, color, v, -validColor) == false) return false;
            }
            else {
                if (color[cur] == color[v]) return false;
            }
        }
        return true;
    }
}
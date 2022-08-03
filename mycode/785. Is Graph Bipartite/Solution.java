class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        // 图不一定联通
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (traverse(graph, color, i, 1) == false) return false;
            }
        }
        return true;
    }
    
    // defination: check if color is valid while coloring cur node and its adjacent nodes
    // 1. if cur node has been visited, check whether the color of cur is valid color, return true if it is; return false if not.
    // 2. cur node has not been visited, give valid color to cur and then give the other color to its adjecanct nodes
    public boolean traverse(int[][] graph, int[] color, int cur, int validColor) {
        if (color[cur] != 0) {
            if (color[cur] == validColor) return true;
            else return false;
        }
        color[cur] = validColor;
        for (int v : graph[cur]) {
            if (traverse(graph, color, v, -validColor) == false) return false;
        }
        return true;
    }
    
}


//the following solution put condition statement inside for loop(adjacent nodes):

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] color = new boolean[n];
        boolean[] visited = new boolean[n];
        boolean res = true;
        // 图不一定联通
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res = res && traverse(graph, visited, color, i);
            }
        }
        return res;
    }
    
    public boolean traverse(int[][] graph, boolean[] visited, boolean[] color, int cur) {
        boolean res = true;
        visited[cur] = true;
        for (int v : graph[cur]) {
            if (visited[v] == false) {
                color[v] = !color[cur];
                // 只有没访问过的节点才调用traverse
                res = res && traverse(graph, visited, color, v);
            }
            else {
                if (color[v] == color[cur]) {
                    return false;
                }
                // else return true;    // wrong answer after adding this line...
            }
        }
        return res;
    }
    
}
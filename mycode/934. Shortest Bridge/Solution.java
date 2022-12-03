class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] visited = new int[n][m];
        List<int[]> island = new ArrayList<>();
        // boolean found = false;
A:      for (int i = 0; i < n; i++) {
            // if (found) break;
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    island = bfs(grid, dirs, visited, i, j);
                    // dfs(grid, dirs, visited, i, j, island);
                    // found = true;
                    // System.out.println("!!!");
                    break A;
                    // break;
                }
            }
            // if (island.size() != 0) break;
        }
        
        Queue<int[]> q = new LinkedList<>(island);
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            // System.out.println(size);
            for (int s = 0; s < size; s++) {
                int[] cur = q.poll();
                // if (grid[cur[0]][cur[1]] == 1 && visited[cur[0]][cur[1]] == 0) {
                //     return dist;
                // }
                // System.out.println(cur[0] + " " + cur[1]);
                for (int[] d : dirs) {
                    int di = cur[0] + d[0];
                    int dj = cur[1] + d[1];
                    // System.out.println(di + " " + dj + "!");
                    if (di < 0 || dj < 0 || di >= n || dj >= m || visited[di][dj] == 1) continue;
                    if (grid[di][dj] == 0) {
                        grid[di][dj] = grid[cur[0]][cur[1]] + dist + 1;
                        q.add(new int[]{di, dj});
                        visited[di][dj] = 1;
                    }  
                    else if (grid[di][dj] == 1 && visited[di][dj] == 0) {
                        // System.out.println("return ");
                        return dist;
                    }
                }
            }
            dist++;            
        }
        return -1;
        
    }
    
    public List<int[]> bfs(int[][] grid, int[][] dirs, int[][] visited, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        List<int[]> res = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            res.add(cur);
            // visited[cur[0]][cur[1]] = 1;
            // System.out.println(cur[0] + " " + cur[1]);
            for (int[] d : dirs) {
                int di = cur[0] + d[0];
                int dj = cur[1] + d[1];
                // System.out.println(di + " " + dj + "!");
                if (di >= 0 && dj >= 0 && di < n && dj < m && visited[di][dj] == 0 && grid[di][dj] == 1) {
                    q.add(new int[]{di, dj});
                    visited[di][dj] = 1;
                }
            }
        }
        return res;
    }
    
    public void dfs(int[][] grid, int[][] dirs, int[][] visited, int i, int j, List<int[]> res) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] == 1 || grid[i][j] == 0) return;
        res.add(new int[]{i, j});
        visited[i][j] = 1;
        for (int[] d : dirs) {
            int di = i + d[0];
            int dj = j + d[1];
            dfs(grid, dirs, visited, di, dj, res);
        }
    }
}
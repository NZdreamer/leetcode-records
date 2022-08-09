class Solution {
    public int numEnclaves(int[][] grid) {
        
        for (int i = 0; i < grid.length; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, grid[0].length - 1);
        }
        for (int j = 0; j < grid[0].length; j++) {
            dfs(grid, 0, j);
            dfs(grid, grid.length - 1, j);
        }
        
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += dfs(grid, i, j);
                }
            }
        }
        return res;
    }
    
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
            return 0;
        }
        if (grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int num = 1;
        for (int[] dir : dirs) {
            num += dfs(grid, i + dir[0], j + dir[1]);
        }
        return num;
    }
}
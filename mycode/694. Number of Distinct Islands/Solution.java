class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    HashSet<String> set = new HashSet<>();
    
    public int numDistinctIslands(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, 0);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    
    
    public void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
            return;
        }
        if (grid[i][j] == 0) return;
        
        grid[i][j] = 0;
        sb.append(dir);
        for (int k = 0; k < 4; k++) {
            int[] d = dirs[k];
            dfs(grid, i + d[0], j + d[1], sb, k);
        }
        sb.append(dir);
    }
}
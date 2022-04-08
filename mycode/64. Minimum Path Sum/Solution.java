class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];

        for (int i = 2; i <= grid.length; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 2; i <= grid[0].length; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                dp[i][j] = grid[i - 1][j - 1] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        return dp[grid.length][grid[0].length];
    }
}
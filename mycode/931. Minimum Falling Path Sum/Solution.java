class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n + 2];
        for (int j = 1; j <= n; j++) {
            dp[0][j] = matrix[0][j - 1];
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][n + 1] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + matrix[i][j - 1];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 1; j < n + 1; j++) {
            res = Math.min(dp[m - 1][j], res);
        }
        return res;
    }
}
class Solution {
//     public int maximalSquare(char[][] matrix) {
//         int max = 0;
//         int[][] memo = new int[matrix.length][matrix[0].length];
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[0].length; j++) {
//                 memo[i][j] = -1;
//             }
//         }
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[0].length; j++) {
//                 if (matrix[i][j] == '1') {
//                     //System.out.println(dfs(matrix, i, j));
//                     if (memo[i][j] == -1) memo[i][j] = dfs(matrix, i, j, memo);
//                     max = Math.max(max, memo[i][j]);
//                 }
//             }
//         }
//         return max * max;
//     }
    
//     public int dfs(char[][] matrix, int i, int j, int[][] memo) {
//         if (i >= matrix.length || j >= matrix[0].length || matrix[i][j] == '0') return 0;
//         if (memo[i][j] != -1) return memo[i][j];
//         memo[i][j] = Math.min(dfs(matrix, i + 1, j, memo), Math.min(dfs(matrix, i, j + 1, memo), dfs(matrix, i + 1, j + 1, memo))) + 1;
//         return memo[i][j];
//     }
    
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(max, dp[i][0]);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            dp[0][j] = matrix[0][j] - '0';
            max = Math.max(max, dp[0][j]);
        }
        
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (matrix[i][j] == '0') continue;
                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                max = Math.max(max, dp[i][j]);
            }
        } 
        return max * max;
    }
}
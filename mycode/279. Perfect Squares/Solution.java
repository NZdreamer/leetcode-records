class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
//         int i = 1;
//         int j = 1;
//         while (j <= n) {
//             dp[j] = 1;
//             i++;
//             j = i * i;
//         }
        
//         for (int k = 1; k < n + 1; k++) {
//             for (int u = 1; u < k; u++) {
//                 dp[k] = Math.min(dp[k], dp[u] + dp[k - u]);
//             }
//         }
        
        dp[0] = 0;
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }        
        
        return dp[n];
    }
}
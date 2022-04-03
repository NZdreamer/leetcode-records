class Solution {
//     public int rob(int[] nums) {
//         int[] dp = new int[nums.length + 1];   
        
//         dp[0] = 0;
//         for(int i = 1; i < dp.length; i++) {
//             dp[i] = nums[i - 1];
//         } 
        
//         for (int i = 1; i < dp.length; i++) {
//             for (int j = 0; j < i - 1; j++) {
//                 dp[i] = Math.max(dp[i], dp[j] + nums[i - 1]);
//             }
//         }
        
//         int res = 0;
//         for (int i = 0; i < dp.length; i++) {
//             res = Math.max(res, dp[i]);
//         }
//         return res;
//     }
    
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        
        // for (int i = 0; i < nums.length; i++) {
        //     dp[i + 2] = Math.max(dp[i + 1], dp[i] + nums[i]);
        // }
        
        // dp[0] = 0;
        // dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
        }
        
        return dp[dp.length - 1];
    }
}
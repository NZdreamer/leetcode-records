class Solution {
    public int jump(int[] nums) {
//         int[] dp = new int[nums.length];
        
//         dp[0] = 0;
//         for (int i = 1; i < dp.length; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (nums[j] >= i - j) {
//                     dp[i] = dp[j] + 1;
//                     break;
//                 }
//             }
//         }
        
//         return dp[nums.length - 1];
        
        int jumps = 0;
        int curEnd = 0;
        int curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, nums[i] + i);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
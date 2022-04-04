class Solution {
//     public boolean canJump(int[] nums) {
//         boolean[] dp = new boolean[nums.length];
        
//         dp[0] = true;
//         for (int i = 1; i < dp.length; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (dp[j] && nums[j] >= i - j) {
//                     System.out.println(nums[j] - i + j);
//                     dp[i] = true;
//                     break;
//                 }
//             }
//         }
        
//         return dp[dp.length - 1];
//     }
    
    public boolean canJump(int[] nums) {
        int maxLocation = 0;
        for(int i=0; i<nums.length; i++) {
            if(maxLocation<i) return false; // if previous maxLocation smaller than i, meaning we cannot reach location i, thus return false.
            maxLocation = Math.max((i+nums[i]), maxLocation); // greedy:
        }
        return true;
    }
    
}
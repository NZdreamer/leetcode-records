class Solution {
    //     public int minSubArrayLen(int target, int[] nums) {
    //         int minLen = Integer.MAX_VALUE;
    //         int left = 0;
    //         int right = 0;
    //         int sum = 0;

    //         while (right <= nums.length && left < nums.length) {
    //             if (sum < target && right < nums.length) {
    //                 sum += nums[right];
    //                 right++;                
    //             }
    //             else if (sum >= target) {
    //                 minLen = Math.min(minLen, right - left);
    //                 sum -= nums[left];
    //                 left++;                
    //             }
    //             else {
    //                 left++;
    //             }
    //         }
    //         if (minLen == Integer.MAX_VALUE) {
    //             return 0;
    //         }

    //         return minLen;
    //     }
    
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int i = 0;
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
//         while (j < nums.length) {
//             sum += nums[j];
//             j++;
            
//             while (sum >= target) {
//                 min = Math.min(min, j - i);
//                 sum -= nums[i];
//                 i++;
//             }
//         }
        
        for (j = 0; j < nums.length; j++) {
            sum += nums[j];
            
            while (sum >= target) {
                min = Math.min(min, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    

}
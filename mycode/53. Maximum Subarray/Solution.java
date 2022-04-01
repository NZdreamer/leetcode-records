class Solution {
    public int maxSubArray(int[] nums) {
//         int max = Integer.MIN_VALUE;

//         for (int i = 0; i < nums.length; i++) {
//             int sum = 0;
//             for (int j = i; j < nums.length; j++) {
//                 sum += nums[j];
//                 if (max < sum) max = sum;
//             }
//         }

//         return max;

        // int[] dp = new int[nums.length];
        // dp[0] = nums[0];

        int dp = nums[0];
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            max = Math.max(max, dp);
        }
        return max;

        // return dc(0, nums.length - 1, nums);

    }

//     public int dc(int start, int end, int[] nums) {
//         if (start == end) return nums[start];

//         int mid = (start + end) / 2;
//         int left = dc(start, mid, nums);
//         int right = dc(mid + 1, end, nums);

//         int midMaxl = nums[mid];
//         int tmp = 0;
//         for (int i = mid; i >= start; i--) {
//             tmp += nums[i];
//             midMaxl = Math.max(tmp, midMaxl);
//         }

//         int midMaxr = nums[mid];
//         tmp = 0;
//         for (int i = mid; i <= end; i++) {
//             tmp += nums[i];
//             midMaxr = Math.max(tmp, midMaxr);
//         }
//         int midMax = midMaxl + midMaxr - nums[mid];

//         return Math.max(midMax, Math.max(left, right));

//     }
}



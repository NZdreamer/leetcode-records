class Solution {
//     public int search(int[] nums, int target) {
//         // binary search to find the smallest number
//         int lo = 0;
//         int hi = nums.length - 1;

//         while (lo < hi) {
//             int mid = (lo + hi) / 2;
//             if (nums[mid] > nums[hi]) lo = mid + 1;
//             else hi = mid;
//         }

//         int rot = lo;
//         lo = 0;
//         hi = nums.length - 1;

//         // the usual binary search and accounting for rotation
//         while (lo <= hi) {
//             int mid = (lo + hi) / 2;
//             int realmid = (mid + rot) % nums.length;
//             if (nums[realmid] == target) return realmid;
//             if (nums[realmid] < target) lo = mid + 1;
//             else hi = mid - 1;
//         }
//         return -1;
//     }

    public int search(int[] nums, int target) {
        int minIdx = findMinIdx(nums);
        if (target == nums[minIdx]) return minIdx;
        int m = nums.length;
        int start = (target <= nums[m - 1]) ? minIdx : 0;
        int end = (target > nums[m - 1]) ? minIdx : m - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public int findMinIdx(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end -  start) / 2;
            if (nums[mid] > nums[end]) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}
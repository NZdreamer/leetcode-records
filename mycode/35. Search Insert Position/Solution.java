class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        
        while (i < j) {
            int mid = (i + j) / 2;
            if (target == nums[mid]) return mid;
            if (target < nums[mid]) {
                j = mid;
            }
            else {
                i = mid + 1;
            }
        }
        
        if (target > nums[nums.length - 1]) return nums.length;
        
        return i;
    }
}
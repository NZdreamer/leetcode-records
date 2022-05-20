class Solution {
    public int removeDuplicates(int[] nums) {
        // two pointer
        if (nums.length == 0) return 0;
        int i = 1;
        int pre = nums[0];
        for (int j = 1; j < nums.length; j++) {
             if (nums[j] != pre) {
                 pre = nums[j];
                 swap(nums, i, j);
                 i++;                 
             }
        }
        return i;
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
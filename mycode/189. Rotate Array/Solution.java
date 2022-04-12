class Solution {
    public void rotate(int[] nums, int k) {
        // int[] res = new int[nums.length];
        // for (int i = 0; i < k % nums.length; i++) {
        //     res[i] = nums[nums.length - k % nums.length + i];
        // }
        // for (int i = k % nums.length; i < nums.length; i++) {
        //     res[i] = nums[i - k % nums.length];
        // }
        // for (int i = 0; i < nums.length; i++) {
        //     nums[i] = res[i];
        // }
        
    // Hint 3: reverse
         
        // reverse(nums, 0, nums.length - 1);
        // if (k % nums.length != 0) {
        //     reverse(nums, 0, (k - 1) % nums.length);
        // }        
        // reverse(nums, k % nums.length, nums.length - 1);
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        
    }
    
    // Hint 3: reverse
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++; j--;
        }        
    }
}
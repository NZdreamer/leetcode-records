class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int target = nums.length - 2;        
        
        while (target >= 0 && nums[target + 1] <= nums[target]) {
            target = target - 1;
        }
        if (target < 0) {
            for (int i = 0; i < len / 2; i++) {
                swap(i, len - 1 - i, nums);
            }
        }
        else {
            int nextGreater = target + 1;
            for (int i = target + 2; i < len; i++) {
                if (nums[i] > nums[target] && nums[i] <= nums[nextGreater]) {
                    nextGreater = i;
                    //System.out.println("///" + nextGreater);
                }
            }
            swap(target, nextGreater, nums);
            
            for (int i = target + 1; i <= (len + target) / 2; i++) {
                swap(i, len + target - i, nums);
                // int tmp1 = nums[i];
                // nums[i] = nums[len - 1 + target + 1 - i];
                // nums[len - 1 + target + 1 - i] = tmp1;
            }
        }
    }
    
    public void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}                                                                                                 
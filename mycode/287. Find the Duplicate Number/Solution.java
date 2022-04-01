class Solution {
    public int findDuplicate(int[] nums) {
        //solution1

        // int size = nums.length;
        // int helper[] = new int[size];
        // for (int i = 0; i < size; i++) {
        //     if (helper[nums[i]] == nums[i]) {
        //         return nums[i];
        //     }
        //     helper[nums[i]] = nums[i];
        // }
        // return 0;

        //solution2
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
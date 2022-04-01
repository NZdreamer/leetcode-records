// http://www.cs.utexas.edu/~moore/best-ideas/mjrty/

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int maj = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                maj = nums[i];
                count++;
            }
            else {
                if (nums[i] == maj) count++;
                else count--;
            }
        }
        return maj;
    }
}
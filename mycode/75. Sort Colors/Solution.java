class Solution {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) counts[0]++;
            else if (nums[i] == 1) counts[1]++;
            else counts[2]++;
        }
        
        int i = 0;
        for (int c = 0; c < 3; c++) {
            int j = 0;            
            while(i < nums.length && j < counts[c]) {
                nums[i] = c;
                j++;
                i++;
            }
        }
    }
}
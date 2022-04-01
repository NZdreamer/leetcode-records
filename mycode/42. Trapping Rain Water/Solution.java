class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftHighest = height[0];
        int rightHighest = height[n - 1];
        int res =  0;
        int left = 0;
        int right = n - 1;
        while  (left < right) {
            if (height[left] < height[right]) {
                if (leftHighest < height[left]) {
                    leftHighest = height[left];
                }
                else {
                    res += leftHighest - height[left];
                }
                left++;
            }
            else {
                if (rightHighest < height[right]) {
                    rightHighest = height[right];
                }
                else {
                    res += rightHighest - height[right];
                }
                right--;
            }
        }
        return res;


    }
}
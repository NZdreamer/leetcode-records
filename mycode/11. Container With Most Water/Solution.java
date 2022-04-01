class Solution {
    public int maxArea(int[] height) {
        int res = 0;

        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int minh = Math.min(height[l], height[r]);
            res = Math.max(res, minh * (r - l));
            if (height[l] > height[r]) r--;
            else l++;
        }

        return res;
    }
}
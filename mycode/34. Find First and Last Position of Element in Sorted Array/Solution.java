// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int idx = find(0, nums.length - 1, nums, target);
//         if (idx == -1) return new int[]{-1, -1};
        
//         int[] res = new int[]{idx, idx};
//         while(res[0] >= 0 && nums[res[0]] == nums[idx]) {
//             res[0]--;
//         }
//         while (res[1] < nums.length && nums[res[1]] == nums[idx]) {
//             res[1]++;
//         }
//         res[0]++; res[1]--;
//         return res;
//     }
    
//     private int find(int left, int right, int[] nums, int target) {
//         if (left > right) {
//             return -1;
//         }
//         int mid = (left + right) / 2;
//         if (nums[mid] == target) {
//             System.out.println("mid" + mid);
//             return mid;
//         }
//         if (nums[mid] > target) {
//             System.out.println("left");
//             return find(left, mid - 1, nums, target);
//         }
//         if (nums[mid] < target) {
//             System.out.println("right");
//             return find(mid + 1, right, nums, target);
//         }
//         return -1;
//     }
// }

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = 0; 
        int j = nums.length - 1;
        int[] res = new int[]{-1, -1};
        
        if (nums.length == 0) return res;
        
            // Search for the left one
        while (i < j) {
            int mid = (i + j) / 2;
            if(nums[mid] < target) i = mid + 1;
            else j = mid;
        }
        if (nums[i] != target) return res;
        else res[0] = i;
        
          // Search for the right one
        j = nums.length - 1;  // We don't have to set i to 0 the second time.
        while (i < j) {
            int mid = (i + j) / 2 + 1;
            if (nums[mid] > target) j = mid - 1;
            else i = mid;   // So that this won't make the search range stuck.
        }
        res[1] = j;
        
        return res;
    }
}
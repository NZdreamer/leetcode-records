class Solution {
//   public int[] searchRange(int[] nums, int target) {
//         int i = 0; 
//         int j = nums.length - 1;
//         int[] res = new int[]{-1, -1};
        
//         if (nums.length == 0) return res;
        
//             // Search for the left one
//         while (i < j) {
//             int mid = (i + j) / 2;
//             if(nums[mid] < target) i = mid + 1;
//             else j = mid;
//         }
//         if (nums[i] != target) return res;
//         else res[0] = i;
        
//           // Search for the right one
//         j = nums.length - 1;  // We don't have to set i to 0 the second time.
//         while (i < j) {
//             int mid = (i + j) / 2;
//             if (nums[mid] > target) j = mid - 1;
//             else i = mid + 1;   // So that this won't make the search range stuck.
//         }
//         res[1] = j;
        
//         return res;
//     }
        
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = new int[2];
        result[0] = findFirst(nums,target);
        result[1] = findLast(nums,target);
        return result;
        
    }
    
    public int findFirst(int[] nums, int target){
        
        int result = -1;
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + ((high-low)/2);

            if (nums[mid] < target){
                low = mid +1;
            } else if (nums[mid] > target){
                high = mid - 1;
            } else { // nums[mid] == target
                result = mid;

                // because nothing after mid
                // can be the first occurance of target.
                //maybe mid is the first occurance , maybe not
                //so let's narrow the target for [0...mid-1] and find out
                high = mid - 1; 
   
            }
        }

        return result;
  
    }
    
        public int findLast(int[] nums, int target){
        
        int result = -1;
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            
            int mid = low + (high-low)/2;
            
            if (nums[mid] < target){
                low = mid +1;
            } else if (nums[mid] > target){
                high = mid - 1;
            } else { // nums[mid] == target
                result = mid;
                // because nothing before mid
                // can be the last occurance of target.
                //maybe mid is the last occurance , maybe not
                //so let's narrow the target for [mid+1...high] and find out
                low = mid + 1;
   
            }
        }

        return result;
    }
}
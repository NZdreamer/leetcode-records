class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

// when you want to find an specific target element you use lo <= hi.
// When you want to find an element which is not specific element you use lo <hi. for example when you want to find a smallest element or a lower_bound etc.
// In other words, reduce search space by every step.And the remaining last element is your answer.
// by the way, when while loop finishes, for some problem you need to process value of lo. because it is not processed in the while loop. because when lo == hi loop is over.

        // You use while (start <= end) if you are returning the match from inside the loop.
        // You use while (start < end) if you want to exit out of the loop first, and then use the result of start or end to return the match.
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[r]) l = mid + 1;
            else r = mid;
        }

        return nums[r];
    }
}
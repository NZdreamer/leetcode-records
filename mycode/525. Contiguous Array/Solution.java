class Solution {
    public int findMaxLength(int[] nums) {
        // The idea is to change 0 in the original array to -1.
        // Thus, if we find SUM[i, j] == 0 then we know there are even number of -1 and 1 between index i and j
        // Also put the sum to index mapping to a HashMap to make search faster.

        // prefix sum. if two prefix sums with index i, j are equal, sum[i, j] = 0

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        HashMap<Integer, Integer> hm = new HashMap();
        hm.put(0, -1);
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hm.containsKey(sum)) {
                max = Math.max(max, i - hm.get(sum));
            }
            else hm.put(sum, i);
        }
        return max;
    }
}
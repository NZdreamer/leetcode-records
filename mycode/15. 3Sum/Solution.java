class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {

                if (nums[start] + nums[end] + nums[i] > 0) end--;
                else if (nums[start] + nums[end] + nums[i] < 0) start++;
                else {

                    List<Integer> cur = Arrays.asList(nums[i], nums[start], nums[end]);
                    res.add(cur);

                    while (start < end && nums[start+1] == nums[start]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end-1]) {
                        end--;
                    }

                    start++;
                    end--;

                }
            }

            while (i < nums.length - 2 && nums[i] == nums[i+1]) i++;
        }
        return res;
    }
}
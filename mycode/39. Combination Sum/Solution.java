class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList();
        backtrace(res, new ArrayList(), candidates, 0, target);
        return res;
    }
    
    public void backtrace(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start, int remain) {
        if (remain < 0) return;
        if (remain == 0) {
            res.add(new ArrayList(tmp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrace(res, tmp, nums, i, remain - nums[i]);
            tmp.remove(tmp.size() - 1);
        }        
    }
}
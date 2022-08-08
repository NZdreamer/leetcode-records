class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrace(candidates, res, new LinkedList<>(), 0, 0, target);
        return res;
    }
    
    public void backtrace(int[] candidates, List<List<Integer>> res, List<Integer> tmp, int idx, int sum, int target) {
        if (sum == target) {
            res.add(new ArrayList(tmp));
        }
        if (sum > target) return;
        
        for (int i = idx; i < candidates.length; i++) {
            // 如果一个节点有多条值相同的树枝相邻，则只遍历第一条，剩下的都剪掉，不要去遍历
            if (i > idx && candidates[i] == candidates[i - 1]) continue;  // error: i>0.
            tmp.add(candidates[i]);
            sum += candidates[i];
            backtrace(candidates, res, tmp, i + 1, sum, target);
            tmp.remove(tmp.size() - 1);
            sum -= candidates[i];
        }
        
    }
}
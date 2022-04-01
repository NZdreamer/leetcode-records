class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        helper(res, new ArrayList(), nums, 0);
        return res;
    }

// Pick a starting point.
// while(Problem is not solved)
//     For each path from the starting point.
//         check if selected path is safe, if yes select it
//         and make recursive call to rest of the problem
//         before which undo the current move.
//     End For
// If none of the move works out, return false, NO SOLUTON.

    public void helper(List<List<Integer>> list, List<Integer> tmpList, int[] nums, int start) {
        list.add(new ArrayList(tmpList));
        for (int i = start; i < nums.length; i++) {
            tmpList.add(nums[i]);
            helper(list, tmpList, nums, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
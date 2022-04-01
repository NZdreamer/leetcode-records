class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        //backtrack(res, new ArrayList(), nums);
        backtrack(res, 0, nums);
        return res;
    }

//     public void backtrack(List<List<Integer>> list, List<Integer> tmpList, int[] nums) {
//         if (tmpList.size() == nums.length) {
//             list.add(new ArrayList(tmpList));
//             return;
//         }

//         for (int i = 0; i < nums.length; i++) {
//             if (tmpList.contains(nums[i])) continue;
//             tmpList.add(nums[i]);
//             backtrack(list, tmpList, nums);
//             //tmpList.remove((Integer)nums[i]);
//             tmpList.remove(tmpList.size() - 1);
//         }
//     }

    public void backtrack(List<List<Integer>> list, int begin, int[] nums) {
        if (begin == nums.length - 1) {
            List<Integer> tmpList = new ArrayList();
            for (int n : nums) {
                tmpList.add(n);
            }
            list.add(tmpList);
        }

        for (int i = begin; i < nums.length; i++) {
            int tmp = nums[i];
            nums[i] = nums[begin];
            nums[begin] = tmp;
            backtrack(list, begin + 1, nums);
            tmp = nums[i];
            nums[i] = nums[begin];
            nums[begin] = tmp;
        }
    }
}
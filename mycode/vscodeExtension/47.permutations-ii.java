import java.util.*;
/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        backtrace(res, new LinkedList<>(), nums, new boolean[nums.length]);
        return res;
    }

    public void backtrace(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] used) {
        if (tmp.size() == nums.length) {
            res.add(new LinkedList<>(tmp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            // 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
            // 如果前面的相邻相等元素没有用过，则跳过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            tmp.add(nums[i]);
            used[i] = true;
            backtrace(res, tmp, nums, used);
            tmp.remove(tmp.size() - 1);
            used[i] = false;
        }
    }

    // public List<List<Integer>> permuteUnique(int[] nums) {
    // List<List<Integer>> ans = new ArrayList<>();
    // if (nums==null || nums.length==0) { return ans; }
    // permute(ans, nums, 0);
    // return ans;
    // }

    // private void permute(List<List<Integer>> ans, int[] nums, int index) {
    // if (index == nums.length) {
    // List<Integer> temp = new ArrayList<>();
    // for (int num: nums) { temp.add(num); }
    // ans.add(temp);
    // return;
    // }
    // Set<Integer> appeared = new HashSet<>();
    // for (int i=index; i<nums.length; ++i) {
    // HashSet: if contains, remains the same and return false
    // if (appeared.add(nums[i])) {
    // swap(nums, index, i);
    // permute(ans, nums, index+1);
    // swap(nums, index, i);
    // }
    // }
    // }

    // private void swap(int[] nums, int i, int j) {
    // int save = nums[i];
    // nums[i] = nums[j];
    // nums[j] = save;
    // }

}

// @lc code=end

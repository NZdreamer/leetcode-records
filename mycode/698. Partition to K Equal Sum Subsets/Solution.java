class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        
        // boolean[] visited = new boolean[nums.length];
        // 用整数 used 的第 i 位（(used >> i) & 1）的 1/0 来表示 used[i] 的 true/false
        int used = 0;
        return canPartition(nums, used, 0, k, 0, sum / k);
    }
    
    HashMap<Integer, Boolean> memo = new HashMap<>();
    
    public boolean canPartition(int[] nums, int used, int start, int k, int cur_sum, int target) {
        if (k == 1) return true;
        if (cur_sum > target) return false;
        if (cur_sum == target) {   
            boolean res = canPartition(nums, used, 0, k - 1, 0, target);
            memo.put(used, res);
            return res;
        }
        if (memo.containsKey(used)) {
            return memo.get(used);
        }
        
        for (int i = start; i < nums.length; i++) {
            if (((used >> i) & 1) == 1) continue;
            // used[i] = true;
            used |= 1 << i; // 将第 i 位置为 1
            if (canPartition(nums, used, i + 1, k, cur_sum + nums[i], target)) return true;
            // used[i] = false;
            used ^= 1 << i; // 使用异或运算将第 i 位恢复 0
        }
        return false;
    }
}

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap();
        int res = 0;
        for (int num : nums1) {
            for (int num2 : nums2) {
                int tmp = num + num2;
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }            
        }
        
        for (int num : nums3) {
            for (int num2 : nums4) {
                int tmp = num + num2;
                if (map.containsKey(-tmp)) {
                    res += map.get(-tmp);
                }
            }
        }
        
        return res;
    }
}
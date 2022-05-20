class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet();
        HashSet<Integer> set2 = new HashSet();
        List<Integer> list = new LinkedList();
        for (int n : nums1) {
            set.add(n);
        }
        for (int n : nums2) {
            if (set.contains(n)) {
                set2.add(n);
            }
        }
        
        int[] res = new int[set2.size()];
        int i = 0;
        for (int s: set2) {
            res[i] = s;
            i++;
        }
        return res;
    }
}
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // We use a stack to keep a decreasing sub-sequence, whenever we see a number x greater than stack.peek() we pop all elements less than x and for all the popped ones, their next greater element is x
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();    // num -> next greater 
        for (int i = 0; i < nums2.length; i++) {
            while (!s.isEmpty() && nums2[i] > s.peek()) {
                int num = s.pop();
                map.put(num, nums2[i]);
            }
            s.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                res[i] = map.get(nums1[i]);
            }
            else {
                res[i] = -1;
            }
        }
        
        return res;
    }
}
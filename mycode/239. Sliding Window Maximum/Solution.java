class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // remove previous element
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }
            // nums[j] is cur number, poll all elements smaller than cur, then add cur to dq, keeping an ascending order in dq
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);

            // add to res
            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peekFirst()];
            }            
        }
        return res;
    }
}
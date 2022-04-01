import java.util.*;
class Solution {
    public static int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack();
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = nums[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = nums[i];
            }
        }
        while (!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }
        return res;
    }

//    public int[] nextGreaterElements(int[] A) {
//        int n = A.length, res[] = new int[n];
//        Arrays.fill(res, -1);
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < n * 2; i++) {
//            while (!stack.isEmpty() && A[stack.peek()] < A[i % n])
//                res[stack.pop()] = A[i % n];
//            stack.push(i % n);
//        }
//        return res;
//    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        nextGreaterElements(nums);
    }
}

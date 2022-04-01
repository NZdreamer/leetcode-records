import java.util.*;
class Solution {
//    public int[] dailyTemperatures(int[] temperatures) {
//        int[] res = new int[temperatures.length];
//        Stack<Integer> stack = new Stack();
//        for (int i = 0; i < temperatures.length; i++) {
    //可省略，与下面的判断条件重复
//            if (stack.isEmpty()) stack.push(i);
//            else {
    //可简化
//                if (temperatures[i] < temperatures[stack.peek()]) {
//                    stack.push(i);
//                }
//                else {
//                    while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
//                        res[stack.peek()] = i - stack.pop();
//                    }
//                    stack.push(i);
//                }
//            }
//        }
    //可省略，res在初始化时所以元素为0
//        for (int i = 0; i < stack.size(); i++) {
//            res[stack.pop()] = 0;
//        }
//        return res;
//    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
                    dailyTemperatures(temperatures);
    }
}
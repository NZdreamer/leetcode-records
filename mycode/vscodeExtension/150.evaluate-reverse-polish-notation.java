import java.util.Stack;

/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-")
             || token.equals("*") || token.equals("/")) {
                int i1 = stack.pop();
                int i2 = stack.pop();
                if (token.equals("+")) stack.push(i2 + i1);
                else if (token.equals("-")) stack.push(i2 - i1);
                else if (token.equals("*")) stack.push(i2 * i1);
                else if (token.equals("/")) stack.push(i2 / i1);
            }
            else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
// @lc code=end


import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                char pre = stack.pop();
                if (c == ')' && pre != '(') return false;
                if (c == ']' && pre != '[') return false;
                if (c == '}' && pre != '{') return false;                 
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}
// @lc code=end


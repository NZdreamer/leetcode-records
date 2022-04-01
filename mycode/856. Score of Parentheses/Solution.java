class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack();
        stack.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(0);
            }
            else if (s.charAt(i) == ')') {
                int cur = stack.pop();
                int tmp = stack.pop();
                if (cur == 0) {
                    tmp += 1;
                    stack.push(tmp);
                }
                else {
                    tmp += cur * 2;
                    stack.push(tmp);
                }
            }
        }
        return stack.pop();
    }
}
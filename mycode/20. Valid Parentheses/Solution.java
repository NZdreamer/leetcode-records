//class Solution {
//    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack();
//        char[] parentheses = s.toCharArray();
//        for (char c : parentheses) {
//            if (c == '(' || c == '{' || c == '[') {
//                stack.push(c);
//            }
//            else {
//                if (stack.isEmpty()) return false;
//                if (stack.peek() == '(' && c == ')') stack.pop();
//                else if (stack.peek() == '{' && c == '}') stack.pop();
//                else if (stack.peek() == '[' && c == ']') stack.pop();
//                else return false;
//            }
//        }
//        return stack.isEmpty();
//    }
//}

public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
        if (c == '(')
        stack.push(')');
        else if (c == '{')
        stack.push('}');
        else if (c == '[')
        stack.push(']');
        else if (stack.isEmpty() || stack.pop() != c)
        return false;
        }
        return stack.isEmpty();
        }
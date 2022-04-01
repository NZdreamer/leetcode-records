class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int result = 0;
        int num = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            else if (s.charAt(i) == '+') {
                result += sign * num;
                sign = 1;
                num = 0;
            }
            else if (s.charAt(i) == '-') {
                result += sign * num;
                sign = -1;
                num = 0;
            }
            else if (s.charAt(i) == ')') {
                result += sign * num;
                sign = stack.pop();
                num = stack.pop();
                result *= sign;
                result += num;
                num = 0;
            }
            else if(s.charAt(i) == ' ') {
                continue;
            }
            else {
                num = Character.getNumericValue(s.charAt(i)) + 10 * num;    // number = 10 * number + (int)(c - '0');
            }
        }
        result += sign * num;
        return result;
    }
}
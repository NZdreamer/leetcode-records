class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                if (sign == '*' || sign == '/') {
                    int preNum = stack.pop();
                    if (sign == '*') num = preNum * num;
                    else num = preNum / num;
                    stack.push(num);
                }
                else {
                    if (sign == '+') stack.push(num);
                    else stack.push(-1 * num);
                }
                num = 0;
                sign = c;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
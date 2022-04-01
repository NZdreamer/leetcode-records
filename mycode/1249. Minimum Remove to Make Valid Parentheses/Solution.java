class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        char ss[] = s.toCharArray();
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = ss[i];
            if (c == '(') {
                stack.push(i);
            }
            if (c == ')') {
                if (stack.isEmpty()) {
                    ss[i] = '*';
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            ss[stack.pop()] = '*';
        }

        for (int i = 0; i < s.length(); i++) {
            if (ss[i] != '*') {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
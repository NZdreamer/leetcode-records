class Solution {
    public String reverseParentheses(String s) {
        int size = s.length();
        int start = 0;
        int end = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack();
        sb.append(s);
        for (int i = 0; i < size; i++) {
            if (sb.charAt(i) == '(') {
                stack.push(i);
            }
            if (sb.charAt(i) == ')') {
                start = stack.pop();
                end = i;
                String subStr = sb.substring(start + 1, end);
                StringBuilder subSb = new StringBuilder();
                subSb.append(subStr);
                subStr = subSb.reverse().toString();
                sb.replace(start + 1, end, subStr);
            }

        }
        for(int i = 0; i < sb.length();) {
            if (sb.charAt(i) == '(' || sb.charAt(i) == ')') {
                System.out.println(i);
                sb.deleteCharAt(i);
            }
            else i++;
        }
        return sb.toString();
    }
}
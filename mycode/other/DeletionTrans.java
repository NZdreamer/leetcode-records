import java.util.Stack;

class DeleteTrans {
    public static String solution(String s) {
        Stack<Character> stack = new Stack<>();
        //stack.push(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
            }
            else {
                if (stack.peek() + s.charAt(i) == 65 + 66 || stack.peek() + s.charAt(i) == 67 + 68) {
                    stack.pop();
                }
                else {
                    stack.push(s.charAt(i));
                }
            }
        }
        String s1 = stack.toString();
        return s1;
    }

    public static void main(String[] args) {
        String s = DeleteTrans.solution("ACBDACBD");
        System.out.println(s);
    }

}
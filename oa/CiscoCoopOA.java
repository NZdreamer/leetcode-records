import java.util.Stack;

// (ab(b){3}){2} -> (abbbb){2}
// (abbbb){2} -> (abbbbabbbb)

class CiscoCoopOA {
    public static String expandedString(String inputStr) {
        Stack<Character> stack = new Stack<>();
        int i = 0; 
        while (i < inputStr.length()) {
            char c = inputStr.charAt(i);
            stack.push(c);
            if (c == '{') {
                i++;
                int rep = inputStr.charAt(i) - '0';
                stack.pop();    // pop '{m,'
                stack.pop();    // pop ')'
                StringBuilder tmp = new StringBuilder();
                while (stack.peek() != '(') {
                    tmp.insert(0, stack.pop());
                }
                stack.pop();    // pop '('
                for (int j = 0; j < rep; j++) {
                    for (int k = 0; k < tmp.length(); k++) {
                        stack.push(tmp.charAt(k));
                    }
                }
                i++; // skip '}'
            }
            
            i++;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "(ab(b){3}){2}";
        String res = expandedString(input);
        System.out.println(res);
    }
}
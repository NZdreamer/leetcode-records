class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            //System.out.println(str);
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) { // String == can not use
                int num = 0;
                int a = s.pop();
                int b = s.pop();
                switch (str) {
                    case "+":
                        num = b + a;
                        break;
                    case "-":
                        num = b - a;
                        break;
                    case "*":
                        num = b * a;
                        break;
                    case "/":
                        num = b / a;    // order is important with stack
                        break;
                }
                s.push(num);
            }
            else {
                //System.out.println("else: " + str);
                s.push(Integer.parseInt(str));
            }
        }
        return s.pop();
    }
}
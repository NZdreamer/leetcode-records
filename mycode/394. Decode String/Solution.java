import java.lang.*;

class Solution {
    public String decodeString(String s) {
        //StringBuilder res = new StringBuilder();
        Stack<StringBuilder> sbStack = new Stack();
        sbStack.push(new StringBuilder());
        Stack<Integer> nums = new Stack();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                // if (num == 0) {
                //     num = Character.getNumericValue(s.charAt(i));
                // }
                // else {
                num = num * 10 + Character.getNumericValue(s.charAt(i));
                // }
            }
            else if (s.charAt(i) == '[') {
                sbStack.push(new StringBuilder());
                nums.push(num);
                num = 0;
            }
            else if (s.charAt(i) == ']') {
                int curNum = nums.pop();
                String curStr = sbStack.pop().toString();
                for (int j = 0; j < curNum; j++) {
                    sbStack.peek().append(curStr);
                }
            }
            else {
                sbStack.peek().append(s.charAt(i));
            }
        }
        return sbStack.pop().toString();
    }
}
class Solution {
    public String removeDuplicates(String s) {
        // Stack<Character> stack = new Stack();
        // char[] str = s.toCharArray();
        // for (char c : str) {
        //     if (!stack.isEmpty() && stack.peek() == c) {
        //         stack.pop();
        //     }
        //     else {
        //         stack.push(c);
        //     }
        // }
        // StringBuilder sb = new StringBuilder();
        // while (!stack.isEmpty()) {
        //     sb.insert(0, stack.pop());
        // }
        // return sb.toString();
        
        // use stringbuilder directly to avoid reverse
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() != 0 && c == sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // two pointer: can remove n duplicates
    // public String removeDuplicates(String s) {
    //     int i = 0;
    //     char[] str = s.toCharArray();
    //     for (int j = 0; j < s.length(); j++, i++) {
    //         str[i] = str[j];
    //         if (i > 0 && str[i] == str[i - 1]) {
    //             i -= 2;
    //         }
    //     }
    //     return new String(str, 0, i);
        
    // }
}
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split(" +");
        if (words.length == 0) return "";
        // int i = 0;
        // int j = words.length - 1;
        // while (i < j) {
        //     String tmp = words[i];
        //     words[i] = words[j];
        //     words[j] = tmp;
        //     i++; j--;
        // }
        
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i > 0; i--) {
            sb.append(words[i]);
            sb.append(" ");
        }
        sb.append(words[0]);
        return sb.toString();
    }
}
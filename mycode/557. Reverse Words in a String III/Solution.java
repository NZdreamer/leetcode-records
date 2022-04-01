class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String words[] = s.split(" ");
        for (String word : words) {
            StringBuilder tmp = new StringBuilder(word);
            sb.append(tmp.reverse().toString());
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}

// remember the APIs!!!
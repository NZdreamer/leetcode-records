class Solution {
    public List<String> commonChars(String[] words) {
        int[] res = new int[26];
        
        for (int i = 0; i < 26; i++) {
            res[i] = Integer.MAX_VALUE;
        }
        
        // Arrays.fill(res, Integer.MAX_VALUE);
        
        for (String s : words) {
            int[] cur = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                cur[c - 'a']++;
            }
            //s.chars().forEach(c -> ++cur[c - 'a']);
            
            for (int i = 0; i < 26; i++) {
                res[i] = Math.min(res[i], cur[i]);
            }
        }
        
        List<String> list = new LinkedList();
        for (char c = 'a'; c <= 'z'; c++) {
            while (res[c - 'a'] != 0) { 
                // char c = (char) (i+'a');
                list.add("" + c);   //String.valueOf(c)
                res[c - 'a']--;
            }
        }
        
        return list;
    }
}
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            last[c - 'a'] = i;
        }
        
        List<Integer> res = new LinkedList();
        int i = 0;
        while (i < s.length()) {
            int furthest = last[s.charAt(i) - 'a'];
            for (int j = i; j < furthest; j++) {
                furthest = Math.max(furthest, last[s.charAt(j) - 'a']);
            }
            res.add(furthest - i + 1);
            i = furthest + 1;
        }
        
        return res;
    }
}
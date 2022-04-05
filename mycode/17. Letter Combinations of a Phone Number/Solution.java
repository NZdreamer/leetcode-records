class Solution {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        // HashMap<Integer, String> map = new HashMap();
        // map.put(2, "abc");
        // map.put(3, "def");
        // map.put(4, "ghi");
        // map.put(5, "jkl");
        // map.put(6, "mno");
        // map.put(7, "pqrs");
        // map.put(8, "tuv");
        // map.put(9, "wxyz");
        
        List<String> res = new LinkedList();
        
        if (digits == null || digits.length() == 0) return res; 
        
//         backtrace(new StringBuilder(), res, digits, 0, map);
//         return res;
        
        
        combination("", digits, 0, res);
    	return res;
    }
    
    private void combination(String prefix, String digits, int offset, List<String> res) {
        if (offset >= digits.length()) {
            res.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, res);
        }
    }
    
//     public void backtrace(StringBuilder tmp, List<String> res, String digits, int idx, HashMap<Integer, String> map) {
//         if (idx == digits.length()) {
//             res.add(tmp.toString());
//             return;
//         }
        
//         int cur = digits.charAt(idx) - '0';
//         for (int i = 0; i < map.get(cur).length(); i++) {
//             tmp.append(map.get(cur).charAt(i));
//             backtrace(tmp, res, digits, idx + 1, map);
//             tmp.deleteCharAt(tmp.length() - 1);
//         }
//     }
}
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList();
        List<String> tmp = new LinkedList();
        backtrace(res, tmp, s, 0);
        return res;
    }
    
    public void backtrace(List<List<String>> res, List<String> tmp, String s, int idx) {
        if (idx >= s.length()) {
            res.add(new LinkedList(tmp));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                tmp.add(s.substring(idx, i + 1));
                backtrace(res, tmp, s, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++; j--;
        }
        return true;
    }
}
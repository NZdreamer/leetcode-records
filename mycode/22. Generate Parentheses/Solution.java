class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        backtrace("", res, n, 0, 0);
        return res;
    }
    
    public void backtrace(String tmp, List<String> res, int n, int left, int right) {
        if (left == n && right == n) {
            res.add(tmp);
            return;
        }
        
        if (left < n) {
            backtrace(tmp + '(', res, n, left + 1, right);
        }
        if (right < left) {
            backtrace(tmp + ')', res, n, left, right + 1);
        }
    }
}
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        backtrace(res, new LinkedList<>(), 1, k ,n);
        return res;
    }
    
    public void backtrace(List<List<Integer>> res, List<Integer> tmp, int start, int k, int n) {
        if (k == 0) {
            if (n == 0) {
                res.add(new LinkedList<>(tmp));
            }
            else return;
        }
        if (n < 0) return;
        for (int i = start; i < 10; i++) {
            tmp.add(i);
            // n -= i;
            // k--;
            backtrace(res, tmp, i + 1, k - 1, n - i);
            tmp.remove(tmp.size() - 1);
            // n += i;
            // k++;
        }
    }
}
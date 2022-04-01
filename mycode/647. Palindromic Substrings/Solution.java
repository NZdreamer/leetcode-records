
// Idea is start from each index and try to extend palindrome for both odd and even length.

class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += countPali(i, i, s);
            count += countPali(i, i + 1, s);
        }

        return count;
    }

    public int countPali(int l, int r, String s) {
        if (l < 0 || r > s.length() - 1) return 0;
        int cnt = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            cnt++;
            l--;
            r++;
        }
        return cnt;
    }
}
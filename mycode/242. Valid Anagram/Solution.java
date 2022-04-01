class Solution {
    public boolean isAnagram(String s, String t) {
        int[] scnt = new int[26];
        int[] tcnt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            scnt[s.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < t.length(); i++) {
            tcnt[t.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < 24; i++) {
            if (scnt[i] != tcnt[i]) return false;
        }

        return true;
    }
}
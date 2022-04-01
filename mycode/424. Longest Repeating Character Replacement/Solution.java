class Solution {
    public int characterReplacement(String s, int k) {
        char[] ca = s.toCharArray();

        int[] counts = new int[26];
        int start = 0;
        int res = 0;
        int maxCount = 0;

        for (int end = 0; end < s.length(); end++) {
            counts[ca[end] - 'A']++;
            maxCount = Math.max(maxCount, counts[ca[end] - 'A']);

            while (end - start + 1 - maxCount > k) {
                counts[ca[start] - 'A']--;
                start++;
            }

            res = Math.max(res, end - start + 1);
        }

        return res;
    }
}
class Solution {
    public int longestPalindromeSubseq(String s) {
        // dp[i][j]: the longest palindromic subsequence's length of substring(i, j),
        // here i, j represent left, right indexes in the string
        int[][] dp = new int[s.length()][s.length()];

        // base case
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
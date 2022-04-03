class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordsSet = new HashSet();
        for (String word : wordDict) {
            wordsSet.add(word);
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordsSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;  // improve
                }
            }
        }
        return dp[dp.length - 1];
    }
}
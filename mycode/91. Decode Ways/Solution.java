class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        if (s.charAt(0) != '0') dp[1] = 1;
        //else return 0;
        
        for (int i = 2; i < dp.length; i++) {
            if (s.charAt(i - 1) != '0') dp[i] += dp[i - 1];
            int num = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (s.charAt(i - 2) != '0' && num <= 26) dp[i] += dp[i - 2];
        }
        
        return dp[dp.length - 1];
    }
}
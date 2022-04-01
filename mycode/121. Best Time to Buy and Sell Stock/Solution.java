class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int pro = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            }
            else if (prices[i] - buy > pro) {
                pro = prices[i] - buy;
            }
        }
        return pro;

//         int[] buy = new int[prices.length];
//         int[] sell = new int[prices.length];

//         buy[0] = -prices[0];
//         sell[0] = 0;
//         for (int i = 1; i < prices.length; i++) {
//             buy[i] = Math.max(sell[i - 1] - prices[i], buy[i - 1]);
//             sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
//         }
//         return sell[prices.length - 1];
    }
}
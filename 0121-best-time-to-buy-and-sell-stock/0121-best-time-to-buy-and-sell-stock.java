class Solution {
    public int maxProfit(int[] prices) {
        int minu = prices[0];
        int profit = 0;
        for(int i = 1 ; i < prices.length ; i++){
            int cost = prices[i] - minu;
            profit = Math.max(profit , cost);
            minu = Math.min(minu , prices[i]);
        }
        return profit;
    }
}
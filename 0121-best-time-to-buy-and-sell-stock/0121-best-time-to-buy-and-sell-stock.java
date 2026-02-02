class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for(int i : prices){
            int cost = i - min;
            profit = Math.max(profit , cost);
            min = Math.min(min , i);
        }
        return profit;
    }
}
class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices, int fee) {
        dp = new Integer[prices.length][2];
        return f(0 , 0 , fee , prices);
    }
    int f(int i , int buy , int fee , int[] prices){
        if(i == prices.length ) return 0;
        if(dp[i][buy] != null) return  dp[i][buy];

        if(buy == 0) return dp[i][buy] = Math.max( -prices[i] + f(i+1 , 1 , fee , prices) , f(i+1 , buy , fee , prices));
        else return dp[i][buy] = Math.max(+prices[i] - fee + f(i+1 , 0 , fee , prices) , f(i+1 , buy , fee , prices));
    }
}
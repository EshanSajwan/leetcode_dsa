class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2];
        return f(0  ,0 , prices);
    }
    int f(int i , int buy , int[] prices){
        if(i >= prices.length) return 0;
        if(dp[i][buy] != null) return dp[i][buy];

        if(buy == 0) return dp[i][buy] = Math.max( -prices[i] + f(i+1 , 1 , prices) , f(i+1 , buy , prices));
        else return dp[i][buy] = Math.max( +prices[i] + f(i+1+1 , 0 , prices) , f( i+1 , buy , prices));
    }
}
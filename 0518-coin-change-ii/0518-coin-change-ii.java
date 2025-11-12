class Solution {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount +1];

        dp[amount ] = 1;
        for(int i = coins.length -1 ; i>= 0 ; i--){
            for(int j = amount ; j >= 0 ;j--){
                int value = dp[j];
                if(j + coins[i] <= amount) value += dp[j + coins[i]];
                dp[j] = value;
            }
        }
        return dp[0];
    }
    // Bottom Up
    // public int change(int amount, int[] coins) {
    //     int[][] dp = new int[coins.length+ 1][amount+1];

    //     for(int i = 0 ; i< coins.length+1 ; i++) dp[i][amount] = 1;

    //     for(int i = coins.length-1 ; i >= 0; i--){
    //         for(int j = amount ; j >= 0 ;j--){
    //             int ways = 0;

    //             if(j + coins[i] <= amount) ways += dp[i][j + coins[i]];
                
    //             ways += dp[i+1][j];

    //             dp[i][j] =  ways;
    //         }
    //     }
    //     return dp[0][0];
    // }

    // TOP DOWN
    // int find(int index , int sum , int[] coins , int amount , Integer[][] dp){
    //      if(sum == amount) return 1;
    //      if(sum > amount || index == coins.length) return 0;
    //      if(dp[index][sum] != null) return dp[index][sum];
    //     return dp[index][sum] = find(index , sum + coins[index] , coins , amount , dp) + find(index+1 , sum , coins , amount , dp);
    // }
}
class Solution {
    Integer[][] dp;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        dp = new Integer[coins.length][amount +1];
        
        int ans = f(coins.length -1 , amount , coins);
        return ans != (int)1e9 ? ans : -1;
    }
    int f(int i , int amount , int[] coins){

        if(amount == 0) return 0;
        if(amount < 0 || i < 0) return (int)1e9;
        if(i == 0){
            int count = 0;
            while(coins[i] <= amount){
                amount -= coins[i];
                count++;
                if(amount == 0) return count;
            }
            return (int)1e9;
        }

        if(dp[i][amount] != null) return dp[i][amount];

        //take
        int take = (int)1e9;
        if(coins[i] <= amount) take = 1+f(i , amount - coins[i] , coins);

        //notTake
        int notTake = f(i-1 , amount , coins);

        return dp[i][amount] = Math.min(take , notTake);
    }
}
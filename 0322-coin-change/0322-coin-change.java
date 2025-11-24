class Solution {
    // Integer[][] dp;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
       // dp = new Integer[coins.length][amount +1];
       int[] prev = new int[amount +1];
       int[] curr = new int[amount +1];

        for(int i = 0 ; i < coins.length ; i++) prev[0] = 0;

        for(int i = 0 ; i < coins.length ; i++){
            for(int amt = 1 ; amt < amount+1 ; amt++){
                if(i == 0){
                    if(amt % coins[i] == 0) curr[amt] = amt / coins[i];
                    else curr[amt] = (int)1e9;
                }else{
                    //take
                    int take = (int)1e9;
                    if(coins[i] <= amt) take = 1+ curr[amt-coins[i]]; //f(i , amount - coins[i] , coins);

                    //notTake
                    int notTake = prev[amt];// f(i-1 , amount , coins);

                    curr[amt] = Math.min(take , notTake);}
            }
            prev = curr.clone();
        }
        
        int ans = prev[amount]; // f(coins.length -1 , amount , coins);
        return ans != (int)1e9 ? ans : -1;
    }
    // int f(int i , int amount , int[] coins){

    //     if(amount == 0) return 0;
    //     if(amount < 0 || i < 0) return (int)1e9;
        // if(i == 0){
        //     if(amount % coins[i] == 0) return amount / coins[i];
        //     return (int)1e9;
        // }

    //     if(dp[i][amount] != null) return dp[i][amount];

    //     //take
    //     int take = (int)1e9;
    //     if(coins[i] <= amount) take = 1+f(i , amount - coins[i] , coins);

    //     //notTake
    //     int notTake = f(i-1 , amount , coins);

    //     return dp[i][amount] = Math.min(take , notTake);
    // }
}
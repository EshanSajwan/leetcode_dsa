class Solution {
    Integer[] dp;
    public int numTrees(int n) {
        dp = new Integer[n+1];
        dp[0] = dp[1] = 1;
        for(int j = 2; j < n+1 ; j++){
            int ans = 0;
            for(int i = 1 ; i < j+1 ; i++){
                ans += dp[i-1] * dp[j -i];
            }
             dp[j] = ans;
        }
        return dp[n];
    }
    // int f(int n){
    //     if(n == 1 || n == 0) return 1;
    //     if(dp[n] != null) return dp[n];
    //     int ans = 0;
    //     for(int i = 1 ; i < n+1 ; i++){
    //         ans += f(i-1) * f(n -i);
    //     }
    //     return dp[n] = ans;
    // }
}
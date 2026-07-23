class Solution {
    Integer[][] dp;
    int x;
    int mod = (int)1e9 + 7;
    public int numberOfWays(int startPos, int endPos, int k) {
        x = 1000;
        dp = new Integer[3001][k + 1];
        return solve(startPos , endPos , k);
    }
    private int solve(int st ,int end , int k){
        if(st == end && k == 0) return 1;
        if( k == 0 ||
            Math.abs(st - end) > k ||
            (Math.abs(st - end) & 1) != (k & 1)) return 0;
        if(dp[st + x][k] != null) return dp[st + x][k];
        return dp[st + x][k] = 
        ((solve(st + 1 , end , k - 1) % mod)
        + 
        (solve(st - 1 , end , k - 1) % mod))
        % mod;

    }
}
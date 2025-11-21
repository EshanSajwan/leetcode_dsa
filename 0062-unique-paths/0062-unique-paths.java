class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] dp = new Integer[m][n];
        return R(m-1 , n-1 , dp);

    }
    int R(int i , int j , Integer[][] dp){

        if(i == 0 && j == 0 ) return 1;
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != null) return dp[i][j];

        return  dp[i][j] = R(i , j-1 , dp) + R(i-1 , j , dp);
        

    }
}
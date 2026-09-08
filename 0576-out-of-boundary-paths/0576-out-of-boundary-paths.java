class Solution {
    Integer[][][] dp;
    int[][] Dir = {{-1 , 0} , { 0 , 1} , {1 , 0} , {0 , -1}};
    int mod = 1_000_000_007, m , n ;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m ;
        this.n = n ;
        dp = new Integer[m][n][maxMove + 1];
        return rec(startRow , startColumn , maxMove);
    }
    private int rec(int i , int j , int x){
        if(i == m || i == -1 || j == n || j == -1) return 1;
        if(x == 0)  return 0;
        if(dp[i][j][x] != null) return dp[i][j][x];
        int ans = 0;
        for(int[] dir : Dir){
            ans = (ans + (rec(i + dir[0] , j + dir[1] , x - 1) % mod)) % mod;
        }
        return dp[i][j][x] = ans;
    }
}
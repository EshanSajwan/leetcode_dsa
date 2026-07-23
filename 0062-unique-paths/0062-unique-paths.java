class Solution {
    Integer[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new Integer[m + 1][n + 1];
        return path(0 , 0 , m , n);
    }
    private int path(int i , int j , int m , int n){
        if(i == m - 1 && j == n - 1) return 1;
        if(i == m || j == n) return 0;
        if(dp[i][j] != null) return dp[i][j];
        return dp[i][j] = path(i , j + 1, m , n) + path(i + 1, j , m , n);
    }
}
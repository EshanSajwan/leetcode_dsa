class Solution {
    Integer[][] dp;
    int[] dR = {-1 , 0 , +1 , 0};
    int[] dC = {0 , +1 , 0 , -1};
    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        dp = new Integer[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                ans = (ans + dfs(i , j , grid)) % 1000000007;
            }
        }
        return ans;
    }
    private int dfs(int i , int j , int[][] grid ){
        if(dp[i][j] != null) return  dp[i][j] ;
        int ans = 1;
        int m = grid.length;
        int n = grid[0].length;
        for(int x = 0 ; x < 4 ; x++){
            int newR = i + dR[x] , newC = j + dC[x];
            if(newR > -1 && newR < m 
                && newC > -1 && newC < n
                && grid[newR][newC] > grid[i][j])
                    ans =  (ans + dfs(newR , newC , grid )) % 1000000007;
        }
        return  dp[i][j] = ans;
    }
}
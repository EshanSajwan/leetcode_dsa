class Solution {
    Boolean[][][] dp;
    public boolean hasValidPath(char[][] grid) {
        dp = new Boolean[grid.length + grid[0].length][grid.length][grid[0].length];
        if(grid[0][0] == '(' && grid[grid.length - 1][grid[0].length - 1] != '(')
              return dfs(1 , 0 , 0 , grid.length , grid[0].length , grid);
        return false;
    }
    private boolean dfs(int x , int i , int j , int m , int n , char[][] grid ){
        if(i == m-1 && j == n-1) return x == 0;
        if(dp[x][i][j] != null) return dp[x][i][j];
        boolean allOptions = false;
        //down
        if(i + 1 < m){
            if(grid[i + 1][j] == '(' ) allOptions = allOptions || dfs(x + 1, i + 1 , j , m ,n, grid) ;
            else if(x > 0) allOptions = allOptions || dfs( x - 1 , i + 1 , j , m , n , grid) ;
        }
        //right
        if(j + 1 < n){
            if(grid[i][j + 1] == '(') allOptions = allOptions || dfs(x + 1, i , j + 1 , m ,n, grid) ;
            else if(x > 0) allOptions = allOptions || dfs( x - 1 , i , j + 1 , m , n , grid) ;
        }
        return dp[x][i][j] = allOptions;
    }
}
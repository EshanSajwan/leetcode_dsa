class Solution {
    int m , n;
    int[][] grid , cost;
    Integer[][] dp;
    public int minPathCost(int[][] grid, int[][] moveCost) {
        // moveCost[i][j] matlab i-> node se j-> col pe jara hai
        // matlab agar 5 to 0 jara hai toh moveCost[5][1] -> 1 0 ka col hai
        // matlab cost niklegi i -> node value , j -> jis col me jara hai
        this.grid = grid;
        this.cost = moveCost;
        m = grid.length;
        n = grid[0].length;
        dp = new Integer[m][n];
        int ans = (int)1e9;
        for(int i = 0 ; i < n ; i++){
            ans = Math.min( ans , go(0 , i));
        }
        return ans;
    }
    private int go(int i , int j){
        if(i == m - 1){
            return grid[i][j];
        }
        if(dp[i][j] != null ) return dp[i][j];
        int ans = (int)1e9;
        for(int col = 0 ; col < n ; col++){
            ans = Math.min(ans ,
                     grid[i][j] + cost[grid[i][j]][col] + go(i + 1 , col));
        }
        return dp[i][j] = ans;
    }
}
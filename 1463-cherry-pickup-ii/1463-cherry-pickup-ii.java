class Solution {
    int[][] grid;
    int m , n;
    Integer[][][] dp;
    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        m = grid.length; n = grid[0].length;
        dp = new Integer[m][n][n];
        // cherry Utha or robo ko bhej uss spot pe (row , robo1 , robo2)
        return grid[0][0] + grid[0][n - 1] + solve(0 , 0 , n - 1);
    }
    private int solve(int i , int robo1 , int robo2){
        if(i == m-1) return 0;
        if(dp[i][robo1][robo2] != null) return dp[i][robo1][robo2];
        int res = 0;
        for(int j = -1 ; j <= 1 ; j++){
            int r1 = robo1 + j;
            if(r1 < 0 || r1 == n) continue;
            for(int k = -1 ; k <= 1 ; k++){
                int r2 = robo2 + k;
                if(r2 < 0 || r2 == n) continue;
                int ans = grid[i + 1][r1] + grid[i + 1][r2];
                if(r1 == r2) ans -= grid[i + 1][r1];
                res = Math.max(res , ans + solve(i + 1 , r1 , r2));
            }
        }
        return dp[i][robo1][robo2] = res;
    }
}
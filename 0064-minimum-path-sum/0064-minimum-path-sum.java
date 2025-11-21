class Solution {
    Integer[] dp;
    public int minPathSum(int[][] grid) {
        dp = new Integer[grid[0].length];

        for(int i = 0 ;i < dp.length ; i++) {
            if(i == 0) dp[0] = grid[0][0];
            else{
                dp[i] = dp[i-1] + grid[0][i];
            }
        }

        for(int i = 1 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
               if(j == 0){
                dp[j] += grid[i][j];
               }else{
                dp[j] = grid[i][j] + Math.min(dp[j] , dp[j-1]);
               }
            }
        }
        return dp[dp.length -1];
        // return dp[grid.length-1][grid[0].length -1];

        //return mPS(grid.length-1 , grid[0].length -1 , grid);
    }

    // int mPS(int i , int j , int[][] grid){

    //     if(i == 0 && j == 0) return grid[0][0];
    //     if(i < 0 || j < 0 ) return Integer.MAX_VALUE;

    //     if(dp[i][j] != null) return dp[i][j];

    //     int left = mPS(i , j-1 , grid);
    //     int up = mPS(i-1 , j , grid);
    //     int val = Math.min(left , up );

    //     return dp[i][j] = grid[i][j] + val;
    // }
}
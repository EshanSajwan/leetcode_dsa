class Solution {
    Integer[][] dp;
    public int minPathSum(int[][] grid) {
        dp = new Integer[grid.length][grid[0].length];

        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(i == 0 && j == 0) dp[i][j] = grid[0][0];
                else{
                    int up = Integer.MAX_VALUE , left = Integer.MAX_VALUE;
                    if(j-1 >= 0) left = dp[i][j-1];// mPS(i , j-1 , grid);
                    if(i-1 >= 0) up = dp[i-1][j]; // mPS(i-1 , j , grid);
                    int val = Math.min(left , up );

                    dp[i][j] = grid[i][j] + val;
                }
            }
        }
        return dp[grid.length-1][grid[0].length -1];

        //return mPS(grid.length-1 , grid[0].length -1 , grid);
    }

    int mPS(int i , int j , int[][] grid){

        if(i == 0 && j == 0) return grid[0][0];
        if(i < 0 || j < 0 ) return Integer.MAX_VALUE;

        if(dp[i][j] != null) return dp[i][j];

        int left = mPS(i , j-1 , grid);
        int up = mPS(i-1 , j , grid);
        int val = Math.min(left , up );

        return dp[i][j] = grid[i][j] + val;
    }
}
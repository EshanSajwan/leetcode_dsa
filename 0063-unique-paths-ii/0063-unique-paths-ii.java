class Solution {
    Integer[][] dp;
    public int uniquePathsWithObstacles(int[][] og) {
        dp = new Integer[og.length][og[0].length];
        return paths(og.length -1 , og[0].length-1 , og);
    }
    int paths(int i , int j , int[][] og){

        if(i == 0 && j== 0  && og[i][j] != 1) return 1;
        if(i < 0 || j < 0 || og[i][j] == 1) return 0;

        if(dp[i][j] != null) return dp[i][j];

        return dp[i][j] = paths(i , j-1 , og) + paths(i-1 , j , og);
    }
}
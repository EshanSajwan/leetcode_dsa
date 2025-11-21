class Solution {
    int[] dp;
    public int uniquePathsWithObstacles(int[][] og) {
        dp = new int[og[0].length];

        //for(int i = 0 ; i < dp.length ; i++) if(og[0][i] != 1) dp[i] = 1;
        dp[0] = og[0][0] == 0 ? 1 : 0;
        for(int i = 1 ; i < dp.length ; i++) {
            if(og[0][i] != 1) dp[i] = dp[i-1]; 
        }

        for(int i = 1 ;i < og.length ; i++){
            for(int j = 0 ; j < dp.length ; j++){
                if(og[i][j] == 1) dp[j] = 0;
                else{
                    if(j == 0) continue;
                    else dp[j] += dp[j-1];
                }
            }
        }
        return dp[dp.length-1];
        // for(int i = 0 ; i < og.length ; i++){
        //     for(int j = 0 ; j < og[0].length ; j++){
        //         if(i == 0 && j== 0  && og[i][j] != 1) dp[i][j] = 1;
        //         else if(og[i][j] == 1) dp[i][j] = 0;
        //         else
        //        { int left = 0;
        //         if(j-1 >= 0) left = dp[i][j-1];

        //         int up = 0;
        //         if( i-1 >= 0) up = dp[i-1][j];
        //         dp[i][j] = left + up;}

        //     }
        // }
        // return dp[og.length -1][og[0].length-1];
        // return paths(og.length -1 , og[0].length-1 , og);
    }
    // int paths(int i , int j , int[][] og){

    //     if(i == 0 && j== 0  && og[i][j] != 1) return 1;
    //     if(i < 0 || j < 0 || og[i][j] == 1) return 0;

    //     if(dp[i][j] != null) return dp[i][j];

    //     return dp[i][j] = paths(i , j-1 , og) + paths(i-1 , j , og);
    // }
}
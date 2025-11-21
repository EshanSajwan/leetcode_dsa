class Solution {
    int[] dp;
    public int minFallingPathSum(int[][] matrix) {
        int temp[] =  new int[matrix[0].length];
        dp = new int[matrix[0].length];

        for(int i = 0 ; i < dp.length ; i++) temp[i] = matrix[0][i];

        for(int i = 1 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(j == 0) dp[j] = matrix[i][j] + Math.min(temp[0] , temp[1]);
                else if( j == dp.length -1) dp[j] = matrix[i][j] + Math.min(temp[j] , temp[j-1]);
                else dp[j] = matrix[i][j] + Math.min(temp[j] , Math.min(temp[j-1] , temp[j+1]));
            }
            temp = dp.clone();
        }

        int minimum = Integer.MAX_VALUE;
        for(int i = 0 ; i < matrix[0].length ; i++) 
            minimum = Math.min(minimum , temp[i]);
        return minimum;        
    }
    // int  fall(int i , int j , int[][] mat){

    //     if(i < 0 || j < 0 || j == mat[0].length) return Integer.MAX_VALUE;
    //     if(i == 0) return mat[i][j];

    //     if(dp[i][j] != null) return dp[i][j];

    //     int up = Integer.MAX_VALUE , upL = Integer.MAX_VALUE , upR = Integer.MAX_VALUE;
    //     up = fall(i-1 , j , mat);
    //     upL = fall(i-1 , j-1 , mat);
    //     upR = fall(i-1 , j+1 , mat);

    //     int val = Math.min(up , Math.min(upL , upR));

    //     return dp[i][j] = mat[i][j] + val;
    // }
}
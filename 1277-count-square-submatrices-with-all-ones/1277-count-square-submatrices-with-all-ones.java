class Solution {
    public int countSquares(int[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        int sum = 0;
        //copy the first row and col as it is
        for(int i = 0 ; i < dp[0].length ; i++) { // first row
            dp[0][i] = matrix[0][i];
            sum += dp[0][i];
        }
        for(int i = 1 ; i < dp.length ; i++) { // firsr col (skip the 0,0 element)
            dp[i][0] = matrix[i][0];
            sum += dp[i][0];
        }
        for(int i = 1; i < dp.length ; i++){
            for(int j = 1 ;j < dp[0].length ; j++){
                if(matrix[i][j] != 0){
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j] , dp[i][j-1]));
                    sum += dp[i][j];
                }
            }
        }
        return sum;
    }
}
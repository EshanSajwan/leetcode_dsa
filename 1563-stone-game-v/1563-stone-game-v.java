class Solution {

    int[][] sum;
    int[] stones;
    Integer[][] dp;
    public int stoneGameV(int[] stoneValue) {
        stones = stoneValue;
        sum = new int[stones.length][stones.length];
        dp = new Integer[stones.length][stones.length];
        for(int i = 0 ; i < stones.length ; i++){
            int summation = 0;
            for(int j = i ; j < stones.length ; j++){
                summation += stones[j];
                sum[i][j] = summation;
            }
        }
        return solve(0 , stones.length - 1);
    }
    private int solve( int i , int j ){
        if(i == j) return 0;
        if(dp[i][j] != null) return dp[i][j];
        int ans = 0;
        for(int p = i ; p < j ; p++){
            int res = 0,
                leftSum = sum[i][p],
                rightSum = sum[p + 1][j];
            if(leftSum == rightSum){
                res = Math.max(leftSum + solve(i , p) ,
                                rightSum + solve(p + 1, j));
            }
            else if( leftSum < rightSum ){
                res = leftSum + solve(i , p);
            }
            else{
                res = rightSum + solve(p + 1, j);
            }

            ans = Math.max( ans , res);
        }
        return dp[i][j] = ans;
    }
}
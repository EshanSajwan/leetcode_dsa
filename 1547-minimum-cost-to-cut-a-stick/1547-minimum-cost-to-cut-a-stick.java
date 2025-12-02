class Solution {
    Integer[][] dp;
    public int minCost(int n, int[] cuts) {
        dp = new Integer[cuts.length +1][cuts.length +1];
        int[] stick = new int[cuts.length +2];
        Arrays.sort(cuts);
        for(int i = 1; i < stick.length -1 ; i++) stick[i] = cuts[i-1];
        stick[stick.length -1] = n;
        return f(1 , stick.length -2 , stick);
    }
    int f(int i , int j , int[] stick){
        if(i > j ) return 0;

        if(dp[i][j] != null) return dp[i][j];

        int mini = Integer.MAX_VALUE;
        for(int k =  i ; k < j+1 ; k++){
            int cost = stick[j+1] - stick[i-1] + f(i , k-1 , stick) + f(k+1 , j , stick);
            mini = Math.min(mini , cost);
        }
        return dp[i][j] = mini;
    }
}
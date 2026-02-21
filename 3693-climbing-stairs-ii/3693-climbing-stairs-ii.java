class Solution {
    Integer[] dp;
    public int climbStairs(int n, int[] costs) {
        dp = new Integer[costs.length];
        return cS2(0 , costs);
    }
    private int cS2(int i , int[] costs){
        if(i == costs.length) return 0;
        if(dp[i] != null) return dp[i];
        int one = Integer.MAX_VALUE;int two = Integer.MAX_VALUE;int three = Integer.MAX_VALUE;
        // one Step
        if(i < costs.length) one = cS2(i+1 , costs) + costs[i] + 1;
        // 2 Steps
        if(i + 1 < costs.length) two = cS2(i+2 , costs) + costs[i+1] + 4;
        //3 Steps
        if(i + 2 < costs.length) three = cS2(i+3 , costs) + costs[i+2] + 9;

        return dp[i] = Math.min(one , Math.min(two , three));
    }
}
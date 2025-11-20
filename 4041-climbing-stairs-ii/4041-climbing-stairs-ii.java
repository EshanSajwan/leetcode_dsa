class Solution {
    
    public int climbStairs(int n, int[] costs) {
        Integer[] dp = new Integer[costs.length+1];
        return func(0 , costs , dp);
        
    }
    int func(int i , int[] costs , Integer[] dp){
        
        if(i >= costs.length) return 0;

        if(dp[i] != null) return dp[i];

        int one = Integer.MAX_VALUE; int two = Integer.MAX_VALUE; int three = Integer.MAX_VALUE;
        one = costs[i] + 1 + func(i+1 , costs , dp);

        if(i+1 < costs.length ){
            two = costs[i+1] + 4 + func(i+2 , costs , dp);
        }

        if(i+2 < costs.length){
            three = costs[i+2] + 9 + func(i+3 , costs , dp);
        }

        return dp[i] = Math.min(one , Math.min(two , three));

    }
}
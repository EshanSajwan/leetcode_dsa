class Solution {
    Integer[][][] dp;
    public int twoCitySchedCost(int[][] costs) {
        dp = new Integer[costs.length ][costs.length / 2 + 1][costs.length / 2 + 1];
        return solve(0 , costs.length / 2 , costs.length / 2 , costs);
    }
    private int solve(int i , int a , int b , int[][] costs){
        if(i == costs.length) return 0;
        if(dp[i][a][b] != null) return dp[i][a][b];
        int takeA = (int) 1e9 , takeB = (int) 1e9;
        if(a > 0){
            takeA = costs[i][0] + solve( i + 1 , a - 1 , b , costs);
        }
        if(b > 0){
            takeB = costs[i][1] + solve( i + 1 , a , b - 1 , costs);
        }
        return dp[i][a][b] = Math.min(takeA , takeB);
    }
}
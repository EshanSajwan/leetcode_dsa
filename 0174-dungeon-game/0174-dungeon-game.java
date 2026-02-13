class Solution {
    Integer[][] dp;
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length , n = dungeon[0].length;
        dp = new Integer[m][n];

        return dundun(0 , 0 , dungeon);
    }
    private int dundun(int i , int j , int[][] dun){
        int m = dun.length , n = dun[0].length;
        if(i >= m || j >= n) return Integer.MAX_VALUE;
        
        if(i == m-1 && j == n-1) return Math.max(1 , 1 - dun[i][j]);

        if(dp[i][j] != null) return dp[i][j];

        int right = dundun(i , j+1 , dun);
        int down = dundun(i + 1, j , dun);

        int mini = Math.min(right , down);
        return dp[i][j] = Math.max(1 , mini - dun[i][j]);
    }
}
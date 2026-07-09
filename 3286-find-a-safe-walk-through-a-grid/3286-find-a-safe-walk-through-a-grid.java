class Solution {
    int[][] Dir = {{-1 , 0} , {0 , 1} , {1 , 0} , {0 , -1}};
    List<List<Integer>> grid;
    int m , n;
    boolean[][] visit;
    Boolean[][][] dp;
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        this.grid = grid;
        m = grid.size();
        n = grid.get(0).size();
        dp = new Boolean[m][n][150];
        visit = new boolean[m][n];
        return dfs(0 , 0 , (grid.get(0).get(0) == 0 ) ? health : health - 1);
    }
    private boolean dfs(int i , int j , int health){
        if(health == 0) return false;
        if(i == m - 1 && j == n - 1) return true;
        if(dp[i][j][health] != null) return dp[i][j][health] ;
        visit[i][j] = true;
        boolean flag = false;
        for(int[] dir : Dir){
            int newR = i + dir[0] , newC = j + dir[1];
            if(newR < m && newR > -1 && newC < n && newC > -1 && !visit[newR][newC]){
                if(grid.get(newR).get(newC) == 0) flag = flag || dfs(newR , newC , health);
                else flag = flag || dfs(newR , newC , health - 1);
            }
            if(flag) return dp[i][j][health] = true;
        }
        visit[i][j] = false;
        return dp[i][j][health] = false;
    }
}
class Solution {
    boolean visit[][];
    public int numIslands(char[][] grid) {
        visit = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == '1' && !visit[i][j]){
                    island(i , j , grid);
                    count++;
                }
            }
        }
        return count;
    }
    public void island(int i , int j  ,char[][] grid){
        visit[i][j] = true;
        // aage
        if(j+1 < grid[0].length && grid[i][j+1] == '1' && !visit[i][j+1]) island(i , j+1 , grid);
        // niche
        if(i+1 < grid.length && grid[i+1][j] == '1' && !visit[i+1][j]) island(i+1 , j , grid);
        // piche
        if(j-1 > -1 && grid[i][j-1] == '1' && !visit[i][j-1]) island(i , j-1 , grid);
        // upar
        if(i-1 > -1 && grid[i-1][j] == '1' && !visit[i-1][j]) island(i-1 , j , grid);
    }
}
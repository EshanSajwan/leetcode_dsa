class Solution {
    boolean[][] visit;
    int m , n;
    int[][] grid;
    int[][] Dir = {{0 , 1} , {1 , 0} , {0 , -1} , {-1 , 0}};
    
// [[0,0,1,1,0,1,0,0,1,0],
//  [1,1,0,1,1,0,1,1,1,0],
//  [1,0,1,1,1,0,0,1,1,0],
//  [0,1,1,0,0,0,0,1,0,1],
//  [0,0,0,0,0,0,1,1,1,0],
//  [0,1,0,1,0,1,0,1,1,1],
//  [1,0,1,0,1,1,0,0,0,1],
//  [1,1,1,1,1,1,0,0,0,0],
//  [1,1,1,0,0,1,0,1,0,1],
//  [1,1,1,0,1,1,0,1,1,0]]


    public int closedIsland(int[][] grid) {
        m = grid.length; n = grid[0].length;
        visit = new boolean[m][n];
        this.grid = grid;
        int count = 0;
        // boundary me jo usko water banade of dfs se jo connxn hai une bhi
        for(int i = 0 ; i < m ; i++){
            if(grid[i][0] == 0 && !visit[i][0]) pani_pani(i , 0);
            if(grid[i][n - 1] == 0 && !visit[i][n - 1]) pani_pani(i , n-1);
        }
        for(int j = 0 ; j < n ; j++){
            if(grid[0][j] == 0 && !visit[0][j]) pani_pani(0 , j);
            if(grid[m - 1][j] == 0 && !visit[m - 1][j]) pani_pani(m - 1 , j);
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 0 && !visit[i][j]){
                    pani_pani(i , j); count++;
                }
            }
        }
        return count;
    }
    private void pani_pani(int i , int j){
        visit[i][j] = true;
        for(int[] dir : Dir){
            int newR = i + dir[0] , newC = j + dir[1];
            if(newR > -1 && newR < m && newC > -1 && newC < n &&
                !visit[newR][newC] && grid[newR][newC] == 0){
                    pani_pani(newR , newC);
                }
        }
    }
}

class Solution {
    private int ans = 0;
    boolean[][] visit;
    private int allCovered = 0;
    int[] dR = {-1 , 0 , +1 , 0};
    int[] dC = {0 , +1 , 0 , -1};
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        visit = new boolean[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 0){
                    allCovered++;
                }
            }
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    dfs(i , j , grid , 0);
                }
            }
        }
        return ans;
    }
    private void dfs(int i , int j , int[][] grid , int zCount){
        if(grid[i][j] == 2){
            ans++;
            return;
        }
        int m = grid.length , n = grid[0].length;
        visit[i][j] = true;
        for(int x = 0; x < 4 ;x++){
            int newR = i + dR[x] , newC = j + dC[x];
            if( newR > -1 && newR < m &&
                newC > -1 && newC < n &&
                grid[newR][newC] != -1 
                && !visit[newR][newC]){
                    if(grid[newR][newC] == 0 ) 
                         dfs(newR , newC , grid , zCount + 1);
                    else {
                        // 2 hai
                        if(zCount == allCovered) dfs(newR , newC , grid , zCount);

                        // boolean ok = true;
                        // for(int k = 0 ; k < 4 ; k++){
                        //     int tempR = i + dR[k] , tempC = j + dC[k];
                        //     if( tempR > -1 && tempR < m &&
                        //         tempC > -1 && tempC < n &&
                        //         tempR != newR && tempC != newC){
                        //             if(grid[tempR][tempC] == 0 && !visit[tempR][tempC])
                        //                 {
                        //                     ok = false;
                        //                     break;
                        //                 }
                        //             else{
                        //                 // -1 hai
                        //                 continue;
                        //             }
                        //         }
                        // }
                        // if(ok) dfs(newR , newC , grid);
                    }
                }
        }
        visit[i][j] = false;
    }
}
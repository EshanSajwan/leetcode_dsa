class Solution {
    public int surfaceArea(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        int zeroCount = 0 , zS = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++) {
                if(grid[i][j] == 0){
                    zeroCount++;
                }
                if(i - 1 > -1 && grid[i - 1][j] > grid[i][j]) zS += grid[i-1][j] - grid[i][j];
                if(i + 1 < m && grid[i+1][j] > grid[i][j]) zS += grid[i+1][j] - grid[i][j];
                if(j - 1 > -1 && grid[i][j - 1] > grid[i][j]) zS += grid[i][j - 1] - grid[i][j];
                if(j + 1 < n && grid[i][j + 1] > grid[i][j]) zS += grid[i][j + 1] - grid[i][j];
            }
        }
        int extra = 0 , left = 0 , right = 0 , up = 0 , down = 0;
        // up
        for(int j = 0 ; j < n ; j++){
            for(int i = 0 ; i < m ; i++){
                if(i == 0) {
                    up += grid[i][j];
                    extra = grid[i][j];
                }
                // else{
                //     if(grid[i][j] > extra){
                //         up += grid[i][j] - extra;
                //         extra = grid[i][j];
                //     }
                // }
            }
        }
        // right
        for(int i = 0 ; i < m ; i++){
            for(int j = n -1 ; j > -1 ; j--){
                if(j == n-1){
                    right += grid[i][j];
                    extra = grid[i][j];
                }
                //else{
                //     if(grid[i][j] > extra){
                //         right += grid[i][j] - extra;
                //         extra = grid[i][j];
                //     }
                // }
            }
        }
        // down
        for(int j = 0 ; j < n ; j++){
            for(int i = m - 1 ; i > -1 ; i--){
                if(i == m - 1) {
                    down += grid[i][j];
                    extra = grid[i][j];
                }
                // else{
                //     if(grid[i][j] > extra){
                //         down += grid[i][j] - extra;
                //         extra = grid[i][j];
                //     }
                // }
            }
        }
        //left
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(j == 0) {
                    left += grid[i][j];
                    extra = grid[i][j];
                }
                // else{
                //     if(grid[i][j] > extra){
                //         left += grid[i][j] - extra;
                //         extra = grid[i][j];
                //     }
                // }
            }
        }
        
        return left + right + up + down + (m * n) + (m * n) - (2 * zeroCount) + zS;

    }
}
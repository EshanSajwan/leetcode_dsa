class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long sum = 0 , curr = 0 ; 
        int m = grid.length , n = grid[0].length;

        if(m == 1 && n==2 ){
            if(grid[0][0] == grid[0][1]) return true;
            return false;
        }
        if(m == 2 && n==1 ){
            if(grid[0][0] == grid[1][0]) return true;
            return false;
        }
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                sum += grid[i][j];
            }
        }

        Set<Long>  set = new HashSet<>();
        for(int col = 0 ; col < n-1 ; col++){
           
            for(int row = 0 ; row < m ; row++) {
                curr += grid[row][col];
                set.add( (long)grid[row][col] );
            }
            long secHalf = sum - curr;
            long diff = curr - secHalf;
            if( diff == 0 || 
                diff == grid[0][0] ||
                diff == grid[m-1][0] ||
                (col > 1 && m > 1 && set.contains(diff)) ||
                (m == 1 && diff == grid[0][col])
                )   return true; 
        }
        curr = 0;
        set = new HashSet<>();
        for(int col = n-1 ; col > 0; col--){
           
            for(int row = 0 ; row < m ; row++) {
                curr += grid[row][col];
                set.add( (long)grid[row][col] );
            }
            long secHalf = sum - curr;
            long diff = curr - secHalf;
            if( diff == 0 || 
                diff == grid[0][n -1] ||
                diff == grid[m-1][n-1] ||
                (col < n-1 && m > 1 && set.contains(diff)) ||
                (m == 1 && diff == grid[0][col])
                )   return true; 
        }
        curr = 0;
        set = new HashSet<>();
        for(int row = 0 ; row < m -1 ; row++){
            for(int col = 0 ; col < n ; col++) {
                curr += grid[row][col];
                set.add( (long)grid[row][col] );
            }
            long secHalf = sum - curr;
            long diff = curr - secHalf;
            if( diff == 0 || 
                diff == grid[0][0] ||
                diff == grid[0][n-1] ||
                // diff == grid[m-1][n-1] ||
                (row > 0 && n > 1 && set.contains(diff)) ||
                (n == 1 && diff == grid[row][0])
                )   return true; 
        }
        curr = 0;
        set = new HashSet<>();
        for(int row = m-1 ; row > 0 ; row--){
            for(int col = 0 ; col < n ; col++) {
                curr += grid[row][col];
                set.add( (long)grid[row][col] );
            }
            long secHalf = sum - curr;
            long diff = curr - secHalf;
            if( diff == 0 || 
                // diff == grid[0][0] ||
                diff == grid[m-1][0] ||
                diff == grid[m-1][n-1] ||
                (row < m-1  && n > 1 && set.contains(diff)) ||
                (n == 1 && diff == grid[row][0]) 
                )   return true; 
        }
        return false;
    }
}
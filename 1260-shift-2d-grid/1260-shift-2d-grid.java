class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        while(k-- > 0){
            doOperation(grid);
        }
        List<List<Integer>> al = new ArrayList<>();
        for(int i = 0 ; i < grid.length ; i++) {
            al.add( new ArrayList<>() );
            for(int j = 0 ; j < grid[0].length ; j++) al.get(i).add(grid[i][j]);
        }
        return al;
    }
    private void doOperation(int[][] grid){
        int m = grid.length , n = grid[0].length ;
        int temp[] = new int[m];
        for(int i = 0 ; i < m ; i++) temp[i] = grid[i][n - 1];
        for(int i = 0 ; i < m ; i++){
            for(int j = n-1 ; j > 0 ; j--) grid[i][j] = grid[i][j - 1];
        }
        for(int i = 1 ; i < m ; i++) grid[i][0] = temp[i - 1];
        grid[0][0] = temp[m - 1];
    }
}
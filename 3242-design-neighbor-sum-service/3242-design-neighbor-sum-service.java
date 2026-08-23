class NeighborSum {
    int[][] grid;
    int[][] pos;

    public NeighborSum(int[][] grid) {
        this.grid = grid;
        pos = new int[grid.length * grid.length][2];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid.length ; j++){
                pos[grid[i][j]][0] = i;
                pos[grid[i][j]][1] = j;
            }
        }
    }
    
    public int adjacentSum(int value) {
        int a = 0 , b = 0 , c = 0 , d = 0 , i = pos[value][0] , j = pos[value][1];
        if(j + 1 < grid.length) a = grid[i][j + 1];
        if(i + 1 < grid.length) b = grid[i + 1][j];
        if(j - 1 > -1) c = grid[i][j - 1];
        if(i - 1 > -1) d = grid[i - 1][j];
        return a + b + c + d;

    }
    
    public int diagonalSum(int value) {
        int a = 0 , b = 0 , c = 0 , d = 0 , i = pos[value][0] , j = pos[value][1];
        if(j + 1 < grid.length && i - 1 > -1) a = grid[i - 1][j + 1];
        if(i + 1 < grid.length && j + 1 < grid.length) b = grid[i + 1][j + 1];
        if(j - 1 > -1 && i + 1 < grid.length) c = grid[i + 1][j - 1];
        if(i - 1 > -1 && j - 1 > -1) d = grid[i - 1][j - 1];
        return a + b + c + d;
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */
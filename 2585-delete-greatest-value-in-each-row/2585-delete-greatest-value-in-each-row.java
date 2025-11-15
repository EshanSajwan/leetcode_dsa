class Solution {
    public int deleteGreatestValue(int[][] grid) {
        for(int i = 0 ; i < grid.length ;i++){
            Arrays.sort(grid[i]);
        }
        int result = 0;
        for(int col = grid[0].length-1 ; col > -1  ; col-- ){
            int maxy = 0;
            for(int i = 0 ; i < grid.length ; i++){
                   maxy = Math.max(maxy , grid[i][col]);
            }
            result += maxy;
        }
        return result;
    }
}
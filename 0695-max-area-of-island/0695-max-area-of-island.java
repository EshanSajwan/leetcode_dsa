class Solution {
    boolean[][] visit;
    int maxArea;
    public int maxAreaOfIsland(int[][] grid) {
        visit = new boolean[grid.length][grid[0].length];
        maxArea = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                
                if(grid[i][j] == 1 && !visit[i][j]) {
                    ArrayList<Integer> list = new ArrayList<>();
                    dfs(i , j , grid , list);
                    maxArea = Math.max(list.size() , maxArea);
                }
            }
        }
        return maxArea;
    }

    void dfs(int i , int j , int[][] grid , ArrayList<Integer> list){
        visit[i][j] = true;
        list.add(grid[i][j]);      

        //up
        if(i-1 > -1 && grid[i -1][j] == 1 && !visit[i-1][j]) dfs( i-1 , j , grid , list);
        //down
        if(i+1 < grid.length && grid[i +1][j] == 1 && !visit[i+1][j]) dfs( i+1 , j , grid, list);
        //left
        if(j-1 > -1 && grid[i][j -1] == 1 && !visit[i][j -1]) dfs( i , j -1 , grid, list);
        //right
        if(j+1 < grid[0].length && grid[i][j+1] == 1 && !visit[i][j+1]) dfs( i , j +1 , grid , list);

    }
}
class Solution {
    class ds{
        int row , col , minD;
        ds(int i , int j , int k){
            this.row = i;
            this.col = j;
            this.minD = k;
        }
    }
    boolean[][] visit;
    int[][] dist;
    public int[][] updateMatrix(int[][] grid) {
        visit = new boolean[grid.length][grid[0].length];
        dist = new int[grid.length][grid[0].length];
                
        Queue<ds> q = new LinkedList<>();
        
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 0) q.offer(new ds(i , j , 0));
            }
        }
        while(!q.isEmpty()){
            ds curr = q.poll();
            if(visit[curr.row][curr.col]) continue;
            visit[curr.row][curr.col] = true;
            dist[curr.row][curr.col] = curr.minD;
            
            //up
            if(curr.row -1 > -1 && grid[curr.row-1][curr.col] == 1 && !visit[curr.row-1][curr.col])
                    q.offer(new ds(curr.row -1 , curr.col , curr.minD +1));
            //down
            if(curr.row +1 < grid.length && grid[curr.row +1][curr.col] == 1 && !visit[curr.row +1][curr.col])
                    q.offer(new ds(curr.row +1 , curr.col , curr.minD +1));
            //left
            if(curr.col -1 > -1 && grid[curr.row][curr.col -1] == 1 && !visit[curr.row][curr.col -1])
                    q.offer(new ds(curr.row , curr.col -1, curr.minD +1));
            //right
            if(curr.col +1 < grid[0].length && grid[curr.row][curr.col +1] == 1 && !visit[curr.row][curr.col +1])
                    q.offer(new ds(curr.row  , curr.col +1 , curr.minD +1));
        }
        
        return dist;
    }
}
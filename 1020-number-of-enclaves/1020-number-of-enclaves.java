class Solution {

    class Pair{
        int r , c;
        Pair(int r , int c){
            this.r = r;
            this.c = c;
        }
    }
    public int numEnclaves(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visit = new boolean[grid.length][grid[0].length];

        for(int i = 0 ; i < grid.length ; i++){
            if(grid[i][0] == 1) q.offer(new Pair(i , 0));
            if(grid[i][grid[0].length -1] == 1 ) q.offer(new Pair(i , grid[0].length -1));
        }
        for(int i = 0 ; i < grid[0].length ; i++){
            if(grid[0][i] == 1) q.offer(new Pair(0 , i));
            if(grid[grid.length -1][i] == 1) q.offer(new Pair(grid.length -1 , i));
        }

        while(!q.isEmpty()){
            Pair curr = q.poll();
            if(visit[curr.r][curr.c]) continue;
            visit[curr.r][curr.c] = true;
            //up
            if(curr.r -1 > -1 && grid[curr.r -1][curr.c] == 1 && !visit[curr.r -1][curr.c]) q.offer(new Pair(curr.r -1 , curr.c));
            //down
            if(curr.r +1 < grid.length && grid[curr.r +1][curr.c] == 1 && !visit[curr.r +1][curr.c]) q.offer(new Pair(curr.r +1 , curr.c));
            //left
            if(curr.c -1 > -1 && grid[curr.r][curr.c -1] == 1 && !visit[curr.r][curr.c -1]) q.offer(new Pair(curr.r , curr.c -1));
            //right
            if(curr.c +1 < grid[0].length && grid[curr.r][curr.c +1] == 1 && !visit[curr.r][curr.c +1]) q.offer(new Pair(curr.r , curr.c +1));
        }
        int count = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1 && !visit[i][j]) count++;
            }
        }
        return count;
    }
}
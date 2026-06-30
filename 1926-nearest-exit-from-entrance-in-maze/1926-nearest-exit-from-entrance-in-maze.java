class Solution {
    // record block(int r , int c){}
    char[][] maze;
    int m , n;
    boolean visit[][];
    int[][] Dir = {{-1 , 0} , {0 , 1} , {1 , 0} , {0 , -1}};
    // Set<block> corners;
    public int nearestExit(char[][] maze, int[] entrance) {
        this.maze = maze;
        m = maze.length; n = maze[0].length;
        visit = new boolean[m][n];
        // corners = new HashSet<>();
        // for(int i = 0 ; i < m ; i++){
        //     if(!(i == entrance[0] && entrance[1] == 0)) corners.add( new block(i , 0));
        //     if(!(i == entrance[0] && entrance[1] == n - 1)) corners.add( new block(i , n - 1));
        // }
        // for(int j = 0 ; j < n ; j++){
        //     if(!(0 == entrance[0] && entrance[1] == j)) corners.add( new block(0 , j));
        //     if(!(m-1 == entrance[0] && entrance[1] == j)) corners.add( new block(m-1 , j));
        // }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        visit[entrance[0]][entrance[1]] = true;
        pq.offer(new int[]{entrance[0] , entrance[1] , 0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int i = curr[0] , j = curr[1] , moves = curr[2];
            // if(corners.contains(new block(i , j))) return moves;
            if(i == 0 || j == 0 || i == m-1 || j == n-1){
                if(!(i == entrance[0] && j == entrance[1])) return moves;
            }
            for(int[] dir : Dir){
                int newR = i + dir[0] , newC = j + dir[1];
                if(newR < m && newR > -1 && newC < n && newC > -1 && !visit[newR][newC]
                    && maze[newR][newC] == '.') {
                        visit[newR][newC] = true;
                        pq.offer( new int[]{ newR , newC , moves + 1});
                    }
            }
        }
        return -1;
    }
    // private int dfs(int i, int j){
        
    //     // if boundary return maar
    //     if(corners.contains(new block(i , j))) return 0;
    //     visit[i][j] = true;
    //     int moves = (int)1e9;
    //     for(int[] dir : Dir){
    //         int newR = i + dir[0] , newC = j + dir[1];
    //         if(newR < m && newR > -1 && newC < n && newC > -1 && !visit[newR][newC]
    //            && maze[newR][newC] == '.') moves = Math.min( moves , 1 + dfs(newR , newC));
    //     }
    //     return moves;
    // }
}
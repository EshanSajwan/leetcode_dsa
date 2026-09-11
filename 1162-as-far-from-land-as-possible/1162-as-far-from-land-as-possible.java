class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> a[0] - b[0]);
        Queue<int[]> pq = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1) pq.offer( new int[]{0 , i , j} );
            }
        }
        int ans = 0;
        int[][] Dir = {{0 , 1} , {1 , 0} , {0 , -1} , {-1 , 0}};
        int[][] mat = new int[n][n];

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(mat[curr[1]][curr[2]] == 0) mat[curr[1]][curr[2]] = curr[0];
            else if(mat[curr[1]][curr[2]] > curr[0]){
                mat[curr[1]][curr[2]] = curr[0];
            }
            else continue;
            for(int dir[] : Dir){
                int x = curr[1] + dir[0] , y = curr[2] + dir[1];
                if(x < 0 || x == n || y < 0 || y == n || grid[x][y] == 1) continue;
                pq.offer( new int[]{ curr[0] + 1 , x , y});
            }
            ans = Math.max( ans , mat[curr[1]][curr[2]]);
        }
        return ans > 0 ? ans : -1;
    }
}
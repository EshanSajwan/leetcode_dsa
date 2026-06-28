class Solution {
    public int shortestPath(int[][] grid, int k) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length , n = grid[0].length;
        boolean[][][] visit = new boolean[m][n][40 * 40 + 1];
        int[][] Dir = {{-1 , 0} , {0 , 1} , {1 , 0} , {0 , -1}};
        visit[0][0][k - grid[0][0]] = true;
        q.offer(new int[]{0 , 0 , k - grid[0][0]});
        int steps = 0;
        while(q.size() != 0){
            int size = q.size();
            while(size-- > 0){
                int[] curr = q.poll();
                int r = curr[0] , c = curr[1] , power = curr[2];
                if(r == m - 1 && c == n - 1) return steps;
                for(int[] dir : Dir){
                    int newR = r + dir[0] , newC = c + dir[1];
                    if(newR < m && newR > -1 && newC < n && newC > -1 &&
                        power - grid[newR][newC] > -1 &&
                        !visit[newR][newC][power - grid[newR][newC]] ){
                            visit[newR][newC][power - grid[newR][newC]] = true;
                            q.offer(new int[]{newR , newC , power - grid[newR][newC]});
                        }
                }
            }
            steps++;
        }
        return -1;
    }
}
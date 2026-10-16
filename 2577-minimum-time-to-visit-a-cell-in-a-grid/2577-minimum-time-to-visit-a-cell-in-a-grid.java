class Solution {
    public int minimumTime(int[][] grid) {
        if(grid[0][1] > 1 && grid[1][0] > 1 ) return -1;
        int m = grid.length , n = grid[0].length;
        PriorityQueue<int[]> pq = 
            new PriorityQueue<>((a,b) -> Integer.compare(a[2] , b[2]));
        pq.offer(new int[]{0 , 0 , 0});
        int[][] Dir = {{-1 , 0} , {0 , -1} , {1 , 0} , { 0 , 1}};
        boolean[][] visit = new boolean[m][n];
        visit[0][0] = true;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[0] == m - 1 && curr[1] == n - 1) return curr[2];
            for(int[] dir : Dir){
                int newR = curr[0] + dir[0] , newC = curr[1] + dir[1];
                if(newR > -1 && newC > -1 && newR < m && newC < n &&
                    !visit[newR][newC]){
                    visit[newR][newC] = true;
                    int reqTime = grid[newR][newC];
                    if(reqTime <= curr[2] + 1){
                        pq.offer(new int[]{newR , newC , curr[2] + 1});
                    }
                    else{
                        int currTime = curr[2] ;
                        int diff = reqTime - currTime;
                        if(diff % 2 == 0){
                            pq.offer( new int[]{newR , newC , reqTime + 1});
                        }
                        else{
                            pq.offer(new int[]{newR , newC , reqTime});
                        }
                    }
                }
            }
        }
        return -1;// unreachable
    }
}
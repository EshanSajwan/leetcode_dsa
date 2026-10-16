class Solution {
    public int minTimeToReach(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        PriorityQueue<int[]> pq = 
            new PriorityQueue<>((a,b) -> Integer.compare(a[2] , b[2]));
        boolean[][] visit = new boolean[m][n];
        visit[0][0] = true;
        pq.offer(new int[]{0 , 0 , 0 , 0});
        int[][] Dir = {{-1 ,0}, {0 , -1} , {1, 0} , {0 , 1}};
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[0] == m-1 && curr[1] == n - 1) return curr[2];
            for(int[] dir : Dir){
                int newR = curr[0] + dir[0] , newC = curr[1] + dir[1];
                if(newR > -1 && newC > -1 && newR < m && newC < n &&
                    !visit[newR][newC]){

                        visit[newR][newC] = true;
                    
                        if(curr[2] >= grid[newR][newC]){
                            pq.offer(new int[]{newR , newC ,
                                                curr[2] + 1 + curr[3] ,
                                    curr[3] == 0 ? 1 : 0    });
                        }
                        else{
                            pq.offer(new int[]{newR , newC , 
                                                grid[newR][newC] + 1 + curr[3] ,
                                    curr[3] == 0 ? 1 : 0    });
                        }
                    }
            }
        }
        return -9999999;
    }
}
class Solution {
    record pari(int r , int c , int h){}
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length , n = heightMap[0].length;
        boolean[][] visit = new boolean[m][n];
        PriorityQueue<pari> pq = new PriorityQueue<>((a , b) -> a.h - b.h);

        for(int i = 0 ; i < m ; i++){
            if(!visit[i][0]){
                visit[i][0] = true;
                pq.offer( new pari(i , 0 , heightMap[i][0]));
            }
            if(!visit[i][n - 1]){
                visit[i][n - 1] = true;
                pq.offer( new pari(i , n - 1 , heightMap[i][n - 1]));
            }
        }

        for(int j = 0 ; j < n ; j++){
            if(!visit[0][j]){
                visit[0][j] = true;
                pq.offer( new pari(0 , j , heightMap[0][j]));
            }
            if(!visit[m - 1][j]){
                visit[m - 1][j] = true;
                pq.offer( new pari(m - 1 , j , heightMap[m - 1][j]));
            }
        }

        int[][] Dir = {{-1 , 0} , {0 , 1} , {1 , 0} , {0 , -1}};

        int water = 0;
        while(!pq.isEmpty()){
            pari curr = pq.poll();
            for(int[] dir : Dir){
                int newR = dir[0] + curr.r , newC = dir[1] + curr.c;
                // outside + boundary not allowed
                if(newR < 1 || newC < 1 || newR > m - 2 || newC > n - 2 || visit[newR][newC])
                    continue;
                if(curr.h - heightMap[newR][newC] >= 0){
                    water += curr.h - heightMap[newR][newC];
                    visit[newR][newC] = true;
                    pq.offer( new pari(newR , newC , curr.h));
                }
                else{
                    visit[newR][newC] = true;
                    pq.offer( new pari(newR , newC , heightMap[newR][newC]));
                }
            }
        }
        return water;
    }
}
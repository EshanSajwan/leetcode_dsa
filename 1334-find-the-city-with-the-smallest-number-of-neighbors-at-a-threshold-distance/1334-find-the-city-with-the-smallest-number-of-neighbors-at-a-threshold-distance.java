class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // build dist matrix
        int[][] dist = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i != j){
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int[] e : edges){
            // bidirectional hai
            dist[e[0]][e[1]] = e[2];
            dist[e[1]][e[0]] = e[2];
        }
        // floyd Warshal se sab ka  sab se shortest dist nikal lo
        for(int via = 0 ; via < n ; via++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(dist[i][via] != Integer.MAX_VALUE && dist[via][j] != Integer.MAX_VALUE) 
                        dist[i][j] = Math.min(dist[i][j] , dist[i][via] + dist[via][j]);
                }
            }
        } 
        int count = Integer.MAX_VALUE;
        int node = 0;
        for(int i = 0 ; i< n ;i++){
            int iCount = 0;
            for(int j = 0 ; j < n ; j++){
                if(dist[i][j] <= distanceThreshold) iCount++;
            }
            if(iCount < count){
                count = iCount;
                node = i;
            } else if(iCount == count){
                node = Math.max(node , i);
            }
        }
        return node;
    }
}
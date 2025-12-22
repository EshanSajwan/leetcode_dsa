class Solution {
    int size[];
    int par[];
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        size = new int[n*n];
        par = new int[n*n];
        for(int i = 0 ; i < par.length ; i++){
            par[i] = i;
            size[i] = 1;
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    int[] dR = {-1 , 0 , +1 , 0};
                    int[] dC = {0 , +1 , 0 , -1};
                    for(int x = 0 ; x < 4 ;x++){
                        int newR = i + dR[x];
                        int newC = j + dC[x];
                        int currNode = i * n + j;
                        int checkNode = newR * n + newC;
                        if(inRange(newR , newC , n ) && grid[newR][newC] == 1) UnionBySize(currNode , checkNode);
                    }
                }
            }
        }
        int max = 0;
        for(int i : size) max = Math.max(max , i);
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 0){
                    Set<Integer> set = new HashSet<>();
                    int[] dR = {-1 , 0 , +1 , 0};
                    int[] dC = {0 , +1 , 0 , -1};
                    for(int x = 0 ; x < 4 ;x++){
                        int newR = i + dR[x];
                        int newC = j + dC[x];
                        if(!inRange(newR , newC , n )) continue;
                        int currNode = i * n + j;
                        int checkNode = newR * n + newC;
                        int ultPar_checkNode = findPar(checkNode);
                        if( grid[newR][newC] == 1 && !set.contains(ultPar_checkNode)){
                            set.add(ultPar_checkNode);
                        }
                    }
                    int checkSize = 0;
                    for(Integer UPar : set) checkSize += size[UPar];
                    max = Math.max(max, 1+ checkSize);
                }
            }
        }
        return max;
    }
    int findPar(int node){
        if(node == par[node]) return node;
        return par[node] = findPar(par[node]);
    }
    void UnionBySize(int node1 , int node2){
        int ultPar1 = findPar(node1);
        int ultPar2 = findPar(node2);
        if(ultPar1 == ultPar2) return;
        if(size[ultPar1] < size[ultPar2]){
            par[ultPar1] = ultPar2;
            size[ultPar2] += size[ultPar1];
        }
        else{
            par[ultPar2] = ultPar1;
            size[ultPar1] += size[ultPar2];
        }
    }
    boolean inRange(int i , int j , int n){
        if(i < n && i > -1 && j < n && j > -1) return true;
        return false;
    }
}
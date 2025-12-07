class Solution {
    boolean[] visit;
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        visit = new boolean[isConnected.length +1];
        for(int i = 1 ; i < isConnected.length +1 ; i++){
            if(!visit[i]){
                dfs(i , isConnected);
                count++;
            }
        }
        return count;
    }
    void dfs(int i  , int[][] isConnected ){
        visit[i] = true;
        for(int j = 0 ; j < isConnected[0].length ; j++){
            if(j != i-1 && isConnected[i-1][j] == 1 && !visit[j+1]) dfs(j+1 , isConnected );
        }
    }
}
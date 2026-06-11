class Solution {
    List<List<Integer>> adj;
    int maxDepth = 0;
    boolean[] visit;
    public int assignEdgeWeights(int[][] edges) {
        adj = new ArrayList<>();
        int x = 0;
        for(int[] e : edges){
            x = Math.max( x , Math.max( e[0] , e[1]));
        }
        visit = new boolean[x + 1];
        for(int i = 0 ; i <= x ; i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        for(int i = 1 ;i <= x ;i++) if(!visit[i]) dfs(i , 0);
        long ans = 1;
        for(int i = 1; i < maxDepth ; i++) ans = (ans * 2) % 1_000_000_007;
        return (int) ans;
    }
    private void dfs(int i , int h){
        maxDepth = Math.max(maxDepth , h);
        visit[i] = true;
        for(int  vx : adj.get(i)){
            if(!visit[vx]) dfs(vx , h + 1);
        }
    }
}
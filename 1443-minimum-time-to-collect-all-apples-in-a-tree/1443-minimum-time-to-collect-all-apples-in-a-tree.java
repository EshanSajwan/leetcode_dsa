class Solution {
    List<List<Integer>> adj;
    boolean[] visit;
    List<Boolean> hasApple;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        boolean noApple = true;
        for(boolean isApple : hasApple) {
            if(isApple) {
                noApple = false;
                break;
            }
        }
        if(noApple || hasApple.size() == 1) return 0;
        this.hasApple = hasApple;
        adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adj.add( new ArrayList<>() );
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        visit = new boolean[n];
        return apple(0) - 1;
    }
    private int apple(int i){
        visit[i] = true;
        if(adj.get(i).size() == 1 && visit[adj.get(i).get(0)]){
            if(hasApple.get(i)) return 1;
            else return -1;
        }
        int res = 0;
        for(int vx : adj.get(i)){
            if(!visit[vx]) res += 1 + apple(vx);
        }
        if(res > 0) return res + 1;
        if(hasApple.get(i)) return 1;
        return -1;
    }
}
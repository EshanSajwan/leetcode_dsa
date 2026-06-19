class Solution {
    List<List<Integer>> adj;
    boolean[] visit;
    int[] connection;
    int[] importance;
    class pari{
        int node , connections;
        pari(int i , int c){
            node = i;
            connections = c;
        }
    }
    long res = 0;
    public long maximumImportance(int n, int[][] roads) {
        visit = new boolean[n];
        connection = new int[n];
        importance = new int[n];
        List<pari> al = new ArrayList<>();
        adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] e : roads){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
            connection[e[0]]++;
            connection[e[1]]++;
        }
        for(int i = 0 ; i < n ; i++) {
            al.add(new pari(i , connection[i]));
        }
        Collections.sort(al , (a,b)->{
            if(b.connections != a.connections)
                return b.connections - a.connections;
            return a.node - b.node;
        });
        int imp = n;
        for(int i = 0 ; i < n ; i++){
            importance[al.get(i).node] = imp--;
        }
        for(int i = 0 ; i < n ; i++) if(!visit[i]) totalMaxImp(i);
        return res;
    }
    private void totalMaxImp(int i){
        visit[i] = true;
        for(int vx : adj.get(i)){
            if(visit[vx]) continue;
            res += importance[i] + importance[vx];
        }
    }
}
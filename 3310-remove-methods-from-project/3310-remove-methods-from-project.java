class Solution {
    List<List<Integer>> adj , ultaAdj;
    boolean[] susp , visit;
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        adj = new ArrayList<>();
        ultaAdj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            adj.add( new ArrayList<>() );
            ultaAdj.add( new ArrayList<>() );
        }
        for(int[] e : invocations){
            adj.get(e[0]).add(e[1]);
            ultaAdj.get(e[1]).add(e[0]);
        }
        susp = new boolean[n];
        markSuspecious(k);
        visit = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(!susp[i] && !visit[i]){
                lookForSusp(i);
            }
        }
        visit = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(!susp[i] && !visit[i]){
                visit[i] = true;
                for(int vx : ultaAdj.get(i)) checkForSusp(vx);
            }
        }

        List<Integer> al = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)
            if( !susp[i] ) 
                al.add(i);
        
        return al;
    }
    private void checkForSusp(int i){
        visit[i] = true;
        susp[i] = false;
        for(int vx : ultaAdj.get(i))
            if(!visit[vx])
               checkForSusp(vx);
        
        for(int vx : adj.get(i))
            if(!visit[vx])
               checkForSusp(vx);
        
    }
    private void lookForSusp(int i){
        visit[i] = true;
        susp[i] = false;
        for(int vx : adj.get(i)){
            if(!visit[vx])
                lookForSusp(vx);
        }
    }
    private void markSuspecious(int k){
        if(susp[k]) return;
        susp[k] = true;
        for(int vx : adj.get(k)) markSuspecious(vx);
    }
}
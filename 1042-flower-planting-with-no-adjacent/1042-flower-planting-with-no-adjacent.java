class Solution {
    List<List<Integer>> adj;
    int[] colors ;
    public int[] gardenNoAdj(int n, int[][] paths) {
        colors = new int[n];
        adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++) adj.add( new ArrayList<>() );
        for(int[] p : paths){
            adj.get(p[0]).add(p[1]);
            adj.get(p[1]).add(p[0]);
        }
        for(int i = 0 ; i < n ; i++){
            if(colors[i] == 0) {
                colors[i] = 1;
                rang(i + 1 , 1);
            }
        }
        return colors;
    }
    private void rang( int i , int color){
        
        for(int vx : adj.get(i)){
            if(colors[vx - 1] == 0 ){
                colors[vx - 1] = color == 4 ? 1 : color + 1;
                rang(vx , colors[vx - 1]);
                // return;
            }
            if(colors[vx - 1] == color){
                // me curr ko change karunga ab
                // toh curr pe options kya kya hain ye nikalna hoga
                boolean used[] = new boolean[4];
                for(int node : adj.get(vx)){
                    if(colors[node - 1] != 0) used[ colors[node - 1] -1 ] = true;
                }
                for(int x = 0 ; x < 4 ;x++){
                    if(!used[x]){
                        colors[vx - 1] = x + 1;
                        break; 
                    }
                }
                // colors[vx - 1] = color == 4 ? 1 : color + 1;
                // rang(vx , colors[vx - 1]);
            }
        }
    }
}